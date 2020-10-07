var p1 = new Promise(function(resolve, reject){
    console.log("i am p1");
    resolve("p1执行成功！");
})
var p2 = new Promise(function(resolve, reject){
    console.log("i am p2");
    resolve("p2执行成功！");
})
var p3 = new Promise(function(resolve, reject){
    console.log("i am p3");
    resolve("p2执行成功！");
})

// 起三个异步调用

p1.then(function(data){
    return p2;
})
.then(function(data){
    console.log(data)
    return p3;
})