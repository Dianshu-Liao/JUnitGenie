from py2neo import Graph


class Neo4jCommands:
    graph = Graph("bolt://localhost:7687", auth=("neo4j", "12345678"))

    @staticmethod
    def find_entity(entity_FEN):
        query = f"MATCH (n) WHERE n.FEN = '{entity_FEN}' RETURN n"
        results = Neo4jCommands.graph.run(query).data()
        if len(results) != 1:
            raise ValueError(f'When finding entity {entity_FEN}, got {len(results)} results.')

        return results[0]['n']

    @staticmethod
    def find_pre_entities_in_relation(entity_FEN, relation):
        query = f"MATCH (n)-[r:{relation}]->(m) WHERE m.FEN = '{entity_FEN}' RETURN n"
        results = Neo4jCommands.graph.run(query).data()

        return results

    @staticmethod
    def find_post_entities_in_relation(entity_FEN, relation):
        query = f"MATCH (m)-[r:{relation}]->(n) WHERE m.FEN = '{entity_FEN}' RETURN n"
        results = Neo4jCommands.graph.run(query).data()

        return results

    @staticmethod
    def get_entities_by_label(label):
        query = f"MATCH (n:`{label}`) RETURN n"
        results = Neo4jCommands.graph.run(query).data()
        return results

if __name__ == '__main__':
    entity_FEN = 'org.apache.commons.lang3.CharSetUtils.squeeze(String,String[])'
    relation = 'Has_Method'
    # results = Neo4jCommands.find_entity(entity_FEN)
    # a = 1
    method_belong_to_class = Neo4jCommands.find_pre_entity_in_relation(entity_FEN, relation)
    print(method_belong_to_class)