const request = require('postman-request');

const baseUrl = 'http://api.weatherstack.com/'

let queryUrl = baseUrl+
            'current?access_key=183ab4d9069b6e0c18d9a871c0c09c08' +
            '&query='

let query = 'seoul'

request.get( {url : queryUrl + query, json:true}, function(error, response, body){
    console.log(response.statusCode)
    // console.log(body)
    // 온도만 출력
    console.log(body.current.temperature)
})









