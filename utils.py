import os

class Util:

    @staticmethod
    def get_all_subfiles(folder_path):
        files = [os.path.join(folder_path, f) for f in os.listdir(folder_path) if
                 os.path.isfile(os.path.join(folder_path, f))]
        return files

    @staticmethod
    def list_files(directory):
        file_paths = []
        for root, dirs, files in os.walk(directory):
            for file in files:
                file_path = os.path.join(root, file)
                file_paths.append(file_path)
        return file_paths

    @staticmethod
    def line_numbers_of_txt_file(file_path):
        f = open(file_path, 'r')
        lines = f.readlines()
        f.close()
        return len(lines)


    @staticmethod
    def find_files(directory, endswith):
        all_files = []
        for root, dirs, files in os.walk(directory):
            for file in files:
                if file.endswith(endswith):
                    all_files.append(os.path.join(root, file))
        return all_files

    @staticmethod
    def convert_file_lines_to_list(file_path):
        if os.path.exists(file_path):

            f = open(file_path, 'r')
            lines = f.readlines()
            f.close()
            list_of_lines = []
            for line in lines:
                list_of_lines.append(line.strip())
            return list_of_lines
        else:
            return []



    @staticmethod
    def get_all_linkes(file_path):
        f = open(file_path)
        links = f.readlines()
        f.close()
        all_links = []
        for link in links:
            each_link = link.strip()
            all_links.append(each_link)
        return all_links

    @staticmethod
    def write_content_to_file(file_path, content):
        f = open(file_path, 'w')
        f.write(content)
        f.close()

    @staticmethod
    def read_file_content(file_path):
        f = open(file_path, 'r')
        content = f.read()
        f.close()
        return content

    @staticmethod
    def copy_file(source, destination):
        import shutil
        shutil.copyfile(source, destination)