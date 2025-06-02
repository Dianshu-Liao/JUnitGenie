# Navigating the Labyrinth: Path-Sensitive Unit Test Generation with Large Language Models

This repository contains the artifact for our paper:  
**"Navigating the Labyrinth: Path-Sensitive Unit Test Generation with Large Language Models"**

Due to GitHub’s file size limitations, the complete source code and experimental data are hosted on Google Cloud Drive.  
👉 **[https://drive.google.com/file/d/1xFTGZ2runQymx_xRgJ2Gas33RW-P-SGw/view?usp=sharing](https://drive.google.com/file/d/1xFTGZ2runQymx_xRgJ2Gas33RW-P-SGw/view?usp=sharing)**

---

## 📊 Experimental Data Overview

All experiment-related files are organized under the `experiment_results/` directory:

---

### 📁 `Code_Knowledge_Base/`

Contains code knowledge extracted by **JUnitGenie** across 10 real-world Java projects.

Each project has its own folder, e.g.,:

- `experiment_results/Code_Knowledge_Base/com_fasterxml_jackson_core`
- `experiment_results/Code_Knowledge_Base/org_apache_commons_codec`

Each folder includes:
- `ASTBased_Results.csv` and `ByteBased_Results.csv`: Store extracted code info (e.g., signatures, control-flow graphs, modifiers).
- `Entities/` and `Relations/`: Store code elements and relationships.

The merged data for all projects can be found in:
- `experiment_results/Code_Knowledge_Base/all_projects_info/Entities/`
- `experiment_results/Code_Knowledge_Base/all_projects_info/Relations/`

To import into Neo4j, refer to the `neo4j_import_command.txt` for full command instructions.

---

### 📁 `Effectiveness/` (RQ1)

Evaluates:  
**"How effective is JUnitGenie in generating executable unit test cases, compared to existing tools?"**

- `generated_tests/`:  
  Test cases generated for 2,258 focal methods using 5 baseline tools (Evosuite, Randoop, ChatTester, CoverUp, HITS) and **JUnitGenie**.

- `jacoco_results/`:  
  Contains JaCoCo branch and line coverage reports for all generated tests.

---

### 📁 `Knowledge_Engineering/` (RQ2)

Evaluates:  
**"Which types of contextual knowledge most enhance LLM test generation?"**

Ablation studies are provided to assess the effect of various components:

- `JUnitGenie_without_CKD/`: No Context Knowledge Distillation.
- `JUnitGenie_without_CKD_CKE/`: No CKD or Context Knowledge Extraction.
- `JUnitGenie_without_CKD_CKE_TCR/`: No CKD, CKE, or Test Code Refinement.
- `jacoco_results/`: Coverage results for all configurations.

---

### 📁 `Model_Generality/` (RQ3)

Evaluates:  
**"How well does JUnitGenie generalize across different foundation models?"**

Results include:

- Basic prompting:
  - `basic_prompt_CodeLlama/`
  - `basic_prompt_DeepSeek_Coder/`
  - `basic_prompt_Qwen_results/`

- JUnitGenie prompting:
  - `OurApproach_CodeLlama/`
  - `OurApproach_DeepSeek_Coder/`
  - `our_approach_Qwen_results/`

- `jacoco_results/`: Coverage reports for all model and prompt settings.

---

### 📁 `prompts/`

Contains all prompt templates used in our pipeline:

- `LLM_CFGPath_SemanticContextInfo`: Prompt for test generation.
- `Method_Constraints`: Infers return constraints for dependent methods.
- `CFG_Pruner`: Extracts all CFG paths satisfying a return constraint.
- `Parameters_Constraints`: Infers parameter conditions to follow a given path.
- `Code_Fixer`: Prompts to refine syntax/runtime errors.

---

##  Source Code Usage Guide

### 1. Code Knowledge Extraction

- Main file:  
  `ProjectInfoExtraction/src/main/java/com/_1_Basic_Code_Analysis.java`  
  Extracts code knowledge from source and byte code.

- Configuration:  
  Set the project path in `ProjectInfoExtraction/src/main/java/com/Config.java`

- To extract for all projects:  
  Run `pipelines/module_1_extract_context_aware_knowledge.py`  
  Output is stored under:  
  `experiment_results/Code_Knowledge_Base/<ProjectName>/Entities/` and `Relations/`

---

### 2. Load into Neo4j

Run the following commands from the `experiment_results/Code_Knowledge_Base` directory:

```bash
sudo rm -rf /opt/homebrew/var/neo4j/data/databases/neo4j
sudo cp all_projects_info/Entities/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/
sudo cp all_projects_info/Relations/*.csv /opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/

neo4j-admin database import full --overwrite-destination=true \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/class_level_entities.csv \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/field_entities.csv \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/enum_constant_entities.csv \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/method_level_entities.csv \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/parameter_level_entities.csv \
  --nodes=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/cfg_path_entities.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_parameter_relations.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_field_relations.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_method_relations.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_cfg_path.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/has_enum_constant_relations.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_field.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_enum_constant.csv \
  --relationships=/opt/homebrew/Cellar/neo4j/2025.01.0/libexec/import/uses_method.csv \
  --verbose neo4j
```

Then start the database:

```bash
neo4j start
```

### 3. Generate Unit Tests

Use the following API to automatically retrieve and distill context for any focal method:

File: `pipelines/context_knowledge_distillation.py`

Call:
```python
generate_unit_tests_for_a_method(...)
```


### 4. Full Experiment Pipeline
- run `experiment_code/RQ1_step_1_ourApproach_prompts.py` to generate tests

- run `experiment_code/step_2_format_our_approach_results.py` to format and complete test code

- run all Java files under `ProjectInfoExtraction/src/main/java/com/check_syntax_error_for_ten_projects/` to detect syntax errors
- run `experiment_code/RQ1_step_3_refine_syntax_error.py` to refine syntax errors (1st round)
- run all files under `ProjectInfoExtraction/src/main/java/com/check_syntax_error_iteration/` to repeat syntax check
- run `experiment_code/RQ1_step_3_refine_syntax_error_2nd.py` to refine again (2nd round and onwards)
- Iterate up to 5 rounds with repeated syntax checks.
- run all Java files under `ProjectInfoExtraction/src/main/java/com/remove_syntax_error_for_ten_projects_by_specify_error_message_files/` to remove remaining syntax errors
- From the root of each project, bash `mvn clean test jacoco:report -Dmaven.test.failure.ignore=true -Dtest=$(paste -sd, test_classes_should_be_run.txt)`
- run `experiment_code/RQ1_step_6_refine_runtime_error.py` to refine runtime errors
- run all files under `ProjectInfoExtraction/src/main/java/com/check_syntax_error_iteration/` to check syntax errors
- run `experiment_code/RQ1_step_7_refine_syntax_error_after_runtime.py` to refine syntax errors
- run all Java files under `ProjectInfoExtraction/src/main/java/com/remove_syntax_error_for_ten_projects_by_specify_error_message_files/` to remove all remaining syntax errors



### 5. Evaluation Calculation

- Run `evaluation_metrics_calculation/RQ1.py` to calculate coverage metrics for RQ1.  
- Run `evaluation_metrics_calculation/RQ2.py` to calculate coverage metrics for RQ2.  
- Run `evaluation_metrics_calculation/RQ3.py` to calculate coverage metrics for RQ3.  

⚠️ Please note: Minor fluctuations (up to ±1%) in the coverage results may occur due to factors such as non-determinism in test execution, JVM differences, or slight model generation variations.





