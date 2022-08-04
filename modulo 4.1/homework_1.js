db.createCollection("funcionario")

use funcionario


//insert
db.funcionario.insert(
  {
    "id_usuario": 1,
    "nome": "Mateus Machado",
    "matricula": "0001",
    "salario": 12350.00,
    "comissao": 0
  }
)

db.funcionario.insert(
  {
    "id_usuario": 2,
    "nome": "Alyson Campos",
    "matricula": "0002",
    "salario": 14350.00,
    "comissao": 0
  }
)

//find
db.funcionario.findOne(
  {
    "nome" : "Alyson Campos"
  }
)

db.funcionario.findOneAndDelete(
  {
    "nome" : "Alyson Campos"
  }
)