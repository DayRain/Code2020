var fs = require('fs');

fs.writeFile('./data/test.md',"测试一下写文件", function(error){
    if(error){
        console.log('写入失败');
    }else{
        console.log("写入成功");
    }
})