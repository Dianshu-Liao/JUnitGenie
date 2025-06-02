import os
import re
import sys


from config import Config

def write_printFullStackTrace_to_java_test_dir(java_dir):
    util_dir = os.path.join(java_dir, "util")
    os.makedirs(util_dir, exist_ok=True)

    file_path = os.path.join(util_dir, "StackTraceUtils.java")

    java_code = '''package util;

public class StackTraceUtils {

    public static void printFullStackTrace(Throwable t) {
        while (t != null) {
            System.err.println("Exception: " + t);
            for (StackTraceElement element : t.getStackTrace()) {
                System.err.println("    at " + element);
            }
            t = t.getCause();
            if (t != null) {
                System.err.println("Caused by:");
            }
        }
    }
}
'''

    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(java_code)

    print(f"✅ Created StackTraceUtils.java at: {file_path}")


def replace_printstacktrace_in_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        original_code = file.read()

    # replace printStackTrace()
    pattern = r'(\b\w+)\.printStackTrace\s*\(\s*\)\s*;'
    new_code, count = re.subn(pattern, r'StackTraceUtils.printFullStackTrace(\1);', original_code)

    # Skip file if no replacements
    if count == 0:
        return

    # Automatically add import util.StackTraceUtils; if not available
    import_statement = 'import util.StackTraceUtils;'
    if import_statement not in new_code:
        # Find the location of all import statements and insert them after the last import.
        import_matches = list(re.finditer(r'^import .+?;$', new_code, re.MULTILINE))
        if import_matches:
            last_import = import_matches[-1]
            insert_position = last_import.end()
            new_code = new_code[:insert_position] + '\n' + import_statement + new_code[insert_position:]
        else:
            # In case there is no import, insert it after the package (or at the top of the file)
            package_match = re.search(r'^package .+?;$', new_code, re.MULTILINE)
            if package_match:
                insert_position = package_match.end()
                new_code = new_code[:insert_position] + '\n' + import_statement + new_code[insert_position:]
            else:
                # There's no package, there's no import, it's just plugged in at the beginning.
                new_code = import_statement + '\n' + new_code

    with open(file_path, 'w', encoding='utf-8') as file:
        file.write(new_code)

    print(f"✅ Replaced {count} line(s) + added import in: {file_path}")

def process_directory(directory_path):
    for root, _, files in os.walk(directory_path):
        for filename in files:
            if filename.endswith('.java'):
                file_path = os.path.join(root, filename)
                replace_printstacktrace_in_file(file_path)


if __name__ == '__main__':
    test_dirs = list(Config.package_name_to_test_dir.values())
    for test_dir in test_dirs:
        write_printFullStackTrace_to_java_test_dir(test_dir)
        process_directory(test_dir)
