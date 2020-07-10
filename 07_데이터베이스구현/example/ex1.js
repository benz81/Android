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
// 셔츠 데이터를 맨처음부터 20개만 조회하여, article과 color 를 출력하시오.
let query = 'select article, color from shirts limit 20;'

// connection.query(query, function(error, results, fields){
//     // console.log(results)

//     console.log(results.length)

//     for(let i = 0; i < results.length; i++){
//         console.log(results[i].article)
//     }

// })


// query = 'insert into shirts (article, shirt_size, color, last_worn) \
//           values ("polo shirt", "M", "purple", 50) '

// connection.query(query, function(error, results, fields){
    
//     console.log(results)

// })


// 사이즈가 M 인 셔츠의 데이터를 조회하시오

// query = 'select * from shirts where shirt_size = "M";'

// connection.query(query, function(error, results, fields){    
//     // console.log(results)
//     for(let i = 0; i < results.length; i++){
//         console.log(results[i].shirt_id)
//     }
// })


// 모든 polo shirt 의 사이즈를 L 로 바꾸시오.
// query = 'update shirts set shirt_size = "L" \
//             where article = "polo shirt"'
// connection.query(query, function(error, results, fields){    
    
//     console.log(results)
    
// })

// 마지막으로 입은 날짜(last_worn)가 15일 인 셔츠를, 
// last_worn을 0으로 바꾸시오.
// query = 'update shirts set last_worn = 0 \
//         where last_worn = 15;'
// connection.query(query, function(error, results, fields){    
    
//     console.log(results)
    
// })

// ‘orange’색깔의 셔츠를, 
// 사이즈는 ‘XS’ 로 바꾸고 컬러는 ‘off white’ 로 바꾸시오.

// query = 'update shirts set shirt_size = "XS", \
//         color="off white" where color = "orange" '

// connection.query(query, function(error, results, fields){    
    
//     console.log(results)
    
// })

// 입은지 200일인 오래된 셔츠들은 삭제하시오.

// query = 'delete from shirts where last_worn = 200 '

// connection.query(query, function(error, results, fields){        
//     console.log(results)    
// })

// 탱크탑 셔츠를 삭제하시오.
query = 'delete from shirts where article = "tank top"'

connection.query(query, function(error, results, fields){        
    console.log(results)    
})

connection.end()












