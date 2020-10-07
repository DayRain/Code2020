var fs = require('fs')
fs.readFile('./data/hello.txt', function(error , data){
    console.log(data);
    console.log(error);
})