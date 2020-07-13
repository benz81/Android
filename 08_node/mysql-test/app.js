const connection = require('./mysql_connection.js')


let query = 'select * from memo'

connection.query(query, function(error, results, fields){
    console.log(results)
})

connection.end()


