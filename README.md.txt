# Projeto: Comparação de Estruturas de Dados em Java

## 👥 Integrantes
- Aaron FullStack  

## 📌 Enunciado da Atividade
Implementar um programa em Java que compare o desempenho das estruturas de dados:
- `ArrayList`
- `LinkedList`
- `Vector`

As operações realizadas foram:
1. **Cadastro (inserção)** de 350.000 objetos `Aluno`.
2. **Ordenação** dos alunos por nome.
3. **Exportação** dos dados para arquivos CSV.

O tempo de execução de cada operação foi medido em milissegundos utilizando a classe `MedidorTiempo`.

---

## 💻 Configurações do Computador Utilizado
- **Processador:** Intel Core i7-10750H (2.60GHz, 6 cores / 12 threads)  
- **Memória RAM:** 16 GB DDR4  
- **Sistema Operacional:** Windows 10 Pro 64 bits  
- **Java:** OpenJDK 17  

---

## ⏱️ Tempos Obtidos

| Operação    | ArrayList (ms) | LinkedList (ms) | Vector (ms) |
|-------------|----------------|-----------------|-------------|
| Cadastro    | 1200           | 1450            | 3000        |
| Ordenação   | 900            | 1500            | 950         |
| Exportação  | 400            | 420             | 390         |

*(valores de tempo são apenas exemplo; substituir pelos tempos reais obtidos na execução)*

---

## 📂 Arquivos Gerados
- `alunos_arrayList.csv`  
- `alunos_linkedList.csv`  
- `alunos_vector.csv`  

---

## ⚖️ Licença
Este projeto é licenciado sob a [MIT License](LICENSE.md).
