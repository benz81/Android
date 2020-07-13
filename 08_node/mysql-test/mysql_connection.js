const mysql = require('mysql')

const connection = mysql.createConnection(
    {
        host : 'database-1.c51w3te8io5h.ap-northeast-2.rds.amazonaws.com',
        user : 'node_user',
        database : 'my_test',
        password : 'node1234test'
    }
)

module.exports = connection
