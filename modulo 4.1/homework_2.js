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

db.funcionario.updateOne(
  { nome: "Mateus" },
  {
    $set: { "nome": "Mateus Filipe", comissao: 1000 }           
  }
)

db.funcionario.updateOne(
  { nome: "Julia" },
  {
    $set: { "nome": "Julia Menezes", comissao: 100 }           
  }
)

db.funcionario.find({
  salario: { $gte: 10000 } 
}).sort("nome")

db.funcionario.find({ }).sort( { comissao : 1} )

db.funcionario.aggregate( [
  { $match: { nome: "Julia" } },
  { $group: { _id: "$nome", sumQuantity: {$sum: "$comissao" }} }
] )

db.funcionario.aggregate( [
  { $match: { nome: "Mateus" } },
  { $group: { _id: "$nome", sumQuantity: {$sum: "$salario" }} }
] )
