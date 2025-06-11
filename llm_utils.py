import requests
import os

class LLM_Utils:


    @staticmethod
    def trigger_GPT_API_basedon_http_request(message, model, openai_key, temperature=0):
        # url = "https://api.openai.com/v1/chat/completions"
        url = "https://openkey.cloud/v1/chat/completions"

        headers = {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer {}'.format(openai_key)
        }

        data = {
            "model": model,
            "messages": message,
            "temperature": temperature,
            "top_p": 1,
            "frequency_penalty": 0,
            "presence_penalty": 0,
        }

        response = requests.post(url, headers=headers, json=data)
        # print("Status Code", response.status_code)
        if response.status_code != 200:
            raise ValueError("Failed to get response")
        return response.json()['choices'][0]['message']['content']


    @staticmethod
    def read_prompt_file(filepath):
        with open(filepath, 'r', encoding='utf-8') as f:
            return f.read()


    @staticmethod
    def get_example_subdirectories(directory):
        """
        Get all subdirectories in the specified directory that start with 'Example'.

        Parameters:
            directory (str): The path to the directory to search.

        Returns:
            list: A list of subdirectory names starting with 'Example'.
        """
        if not os.path.exists(directory):
            raise FileNotFoundError(f"The specified directory does not exist: {directory}")

        return [
            subdir for subdir in os.listdir(directory)
            if os.path.isdir(os.path.join(directory, subdir)) and subdir.startswith("Example")
        ]

    @staticmethod
    def read_example_prompts(prompt_dir):
        example_prompt = []
        example_dirs = LLM_Utils.get_example_subdirectories(prompt_dir)

        for example_dir in example_dirs:
            example_input_prompt_file = prompt_dir + '/' + example_dir + '/Input'
            example_output_prompt_file = prompt_dir + '/' + example_dir + '/Output'

            example_input_prompt = LLM_Utils.read_prompt_file(example_input_prompt_file)
            example_output_prompt = LLM_Utils.read_prompt_file(example_output_prompt_file)
            example_user = {'role': 'user', 'content': example_input_prompt}
            example_assistant = {'role': 'assistant', 'content': example_output_prompt}
            example_prompt.append(example_user)
            example_prompt.append(example_assistant)
        return example_prompt


if __name__ == '__main__':
    system_prompt_content = """Test Generator {
    @persona {
        You are an expert in Java programming with a focus on test generation;
        Your task is to generate test cases for a focal method based on provided contextual information;
    }

    @terminology {
        focal_method_source_code: The source code of the method under test (focal method);
	    focal_method_info_in_the_project: The class and method signature of the focal method in its project, which helps generate import statements for testing;
        CFGPath: The control flow graph path of the focal method, indicating the specific execution flow to be tested;
        External_Method_Parameters_Constraints: Represents constraints that the input parameters of external methods (called within the focal method) must satisfy to ensure the CFGPath is executed;
        External_variables: Represents the definitions of external variables (such as class-level variables or variables from other classes) used in the focal method;
        generated_test_code: The generated test code for the focal method to cover the specified CFGPath;
    }

    @instruction {
        Given the focal_method_source_code, focal_method_info_in_the_project, CFGPath, External_Method_Parameters_Constraints, and External_variables, analyze the provided information comprehensively to write the generated_test_code for the focal method, ensuring the CFGPath is covered. Include all necessary imports.

        @rule1: When generating test cases to cover a throw statement, use a try-catch block to handle the exception.
        @rule2: You don't need to rewrite the focal method in the test code, the test file is already created under the test directory.
        @rule3: Use JUnit 4 and JDK 8 for writing the test cases.
        @rule4: If it is necessary to test for "throws Exception", use try-catch block to handle the exception, rather than using assertThrows.
        @rule: Please follow rules 1-4 strictly!

        @format {
            @input: ###focal_method_source_code, ###focal_method_info_in_the_project, ###CFGPath, ###External_Method_Parameters_Constraints, ###External_variables
            @output: ###generated_test_code
        }
    }
}"""

    user_input_content = """###focal_method_source_code
```java
private static byte[] decodeTable(final boolean useHex) {
    return useHex ? HEX_DECODE_TABLE : DECODE_TABLE;
}
```


###focal_method_info_in_the_project
Class: org.apache.commons.codec.binary.Base32
Class Modifiers: public 
Method Signature: byte[] decodeTable(boolean)
Method Modifiers: private , static 
You can access the class by importing the class directly: "import org.apache.commons.codec.binary.Base32"
The method "decodeTable" is a static method, you can access it directly by importing the focal class.
The class "org.apache.commons.codec.binary.Base32" has the following constructors that facilitate its instantiation (you can select one of them to instantiate the class):
"void <init>()"
"void <init>(boolean)"
"void <init>(boolean,byte)"
"void <init>(byte)"
"void <init>(int)"
"void <init>(int,byte[])"
"void <init>(int,byte[],boolean)"
"void <init>(int,byte[],boolean,byte)"
"void <init>(int,byte[],boolean,byte,org.apache.commons.codec.CodecPolicy)"
"void <init>(int,byte[],byte[],byte,org.apache.commons.codec.CodecPolicy)" (this method is private, if you want to access it, you should use "reflection")

The focal method "byte[] decodeTable(boolean)" has modifiers: "private , static"
The focal method "byte[] decodeTable(boolean)" is a private method, you should use "reflection" to access it.
The focal method "byte[] decodeTable(boolean)" is a static method, you can access it directly.




###CFGPath
CFG Nodes:
"6" [label="useHex := @parameter0: boolean"];
"4" [label="if useHex == 0"];
"2" [label="$stack1 = <org.apache.commons.codec.binary.Base32: byte[] HEX_DECODE_TABLE>"];
"3" [label="goto"];
"5" [label="return $stack1"];

CFG Edges:
"6" -> "4"[label="cfg_next"];
"4" -> "2"[label="cfg_false"];
"2" -> "3"[label="cfg_next"];
"3" -> "5"[label="cfg_goto"];

CFG Path: ['6', '4', '2', '3', '5']



###External_Method_Parameters_Constraints
This ###CFG_Path does not contain any external method.


###External_variables
source code of field org.apache.commons.codec.binary.Base32.HEX_DECODE_TABLE (Note that this variable is "private , static , final ") is:
private static final byte[] HEX_DECODE_TABLE = { //  0   1   2   3   4   5   6   7   8   9   A   B   C   D   E   F
// 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 00-0f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 10-1f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 20-2f
-1, // 30-3f 0-9
0, // 30-3f 0-9
1, // 30-3f 0-9
2, // 30-3f 0-9
3, // 30-3f 0-9
4, // 30-3f 0-9
5, // 30-3f 0-9
6, // 30-3f 0-9
7, // 30-3f 0-9
8, // 30-3f 0-9
9, // 30-3f 0-9
-1, // 30-3f 0-9
-1, // 30-3f 0-9
-1, // 30-3f 0-9
-1, // 30-3f 0-9
-1, // 30-3f 0-9
-1, // 40-4f A-O
-1, // 40-4f A-O
10, // 40-4f A-O
11, // 40-4f A-O
12, // 40-4f A-O
13, // 40-4f A-O
14, // 40-4f A-O
15, // 40-4f A-O
16, // 40-4f A-O
17, // 40-4f A-O
18, // 40-4f A-O
19, // 40-4f A-O
20, // 40-4f A-O
21, // 40-4f A-O
22, // 40-4f A-O
23, // 40-4f A-O
24, // 50-56 P-V
25, // 50-56 P-V
26, // 50-56 P-V
27, // 50-56 P-V
28, // 50-56 P-V
29, // 50-56 P-V
30, // 50-56 P-V
31, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 57-5f
-1, // 60-6f a-o
-1, // 60-6f a-o
10, // 60-6f a-o
11, // 60-6f a-o
12, // 60-6f a-o
13, // 60-6f a-o
14, // 60-6f a-o
15, // 60-6f a-o
16, // 60-6f a-o
17, // 60-6f a-o
18, // 60-6f a-o
19, // 60-6f a-o
20, // 60-6f a-o
21, // 60-6f a-o
22, // 60-6f a-o
23, // 60-6f a-o
24, // 70-76 p-v
25, // 70-76 p-v
26, // 70-76 p-v
27, // 70-76 p-v
28, // 70-76 p-v
29, // 70-76 p-v
30, // 70-76 p-v
31 };




###generated_test_code"""

    system_prompt = {'role': 'system', 'content': system_prompt_content}
    user_input = {'role': 'user', 'content': user_input_content}
    prompt = [system_prompt, user_input]
    test_code = LLM_Utils.trigger_GPT_API_basedon_http_request(prompt, model="gpt-4o", openai_key='sk-JWHQ6j8qFDjPH2QD050f3b8bE6534bD6Af5d06E3D594E51e')
    print(test_code)
