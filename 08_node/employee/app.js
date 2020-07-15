// 네트워크를 통해서 다른 서버의 api 를 호출하기 위해서.
const request = require('postman-request');
const connection = require('./mysql_connection')

const baseUrl = 'http://dummy.restapiexample.com'

let path = '/api/v1/employees'

request.get( {url:  baseUrl+path, json:true} , 
    function(error, response, body){
        //console.log(body.data)

        // let query = 'insert into employee (name, salary,age) \
        // values ("'+body.data[0].employee_name+'", '+
        // body.data[0].employee_salary+', '+
        // body.data[0].employee_age+');'
        
        let query = `insert into employee (name, salary, age) 
        values ( "${body.data[1].employee_name}", 
        ${body.data[1].employee_salary}, 
        ${body.data[1].employee_age}  );`

        console.log(query)

        connection.query(query, function(error, results, fields){
            console.log(results)
        })
        connection.end()
    });





