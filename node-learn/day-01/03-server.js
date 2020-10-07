var http = require('http');
var server = http.createServer();

server.on('request', function(request, response){
    response.write('你的请求路径是：'+ request.url);
    response.setCharac
    response.end();
})

server.listen(8080, function(){
    console.log('在8080启动了一个服务');
})