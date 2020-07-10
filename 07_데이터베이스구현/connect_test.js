// 이 파일 안에서, mysql 라이브러리를 사용하겠다.
let mysql = require('mysql')

let connection = mysql.createConnection(
    {
        host : 'database-1.c51w3te8io5h.ap-northeast-2.rds.amazonaws.com',
        user : 'node_user',
        database : 'my_test',
        password : 'node1234test'
    }
);

// let insert_query = 'insert into memo (title, comment) \
//                         values ("hi", "nice to meet you")'
// connection.query(insert_query, function(error, result){
//     console.log(result)
// })

// connection.query('select * from memo where title like "%h%" ' , 
//                 function(error, results, fields){
//                     console.log(results)                    
//                 })
                
let q_like = "%he%"
connection.query('select title from memo where title like ? and id =? ' ,
                [ q_like , 1 ],
                function(error, results, fields){
                    console.log(results)                    
                })

connection.end()







