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

// 유저 데이터를 30개만 가져와서, 이메일 주소와 날짜를 출력하시오.
let query = 'select email, created_at from users limit 30;'

// connection.query(query, function(error, results, fields){        
//     console.log(results)    
// })

// 가장 먼저 회원가입한 사람의 이메일과 가입일을 출력하시오.
// query = 'select * from users order by created_at limit 1;'

// connection.query(query, function(error, results, fields){        
//     console.log(results[0].email + " , " +
//                 results[0].created_at.toString())    
// })


// query = 'select monthname(created_at) as month, count(*) as count \
//             from users \
//             group by month \
//             order by count desc;'

// connection.query(query, function(error, results, fields){        
//     console.log(results)  
// })

// query = 'select * from users \
//         where email like "%yahoo%"  \
//         order by created_at desc limit 20;'

// connection.query(query, function(error, results, fields){        
//     console.log(results)  
// })

query = 'select count(*) as cnt from users \
            where email like "%yahoo%";'

connection.query(query, function(error, results, fields){        
    console.log(results)  
})


connection.end()








