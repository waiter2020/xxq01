/*
    @auther randall Hu
    @date 2018-7-13
    三级联动

 */

var one = document.getElementById('search1');
var two = document.getElementById('search2');
var i,op;
//二元申明
child = [];
//定义二级数据
child[0] = ['开发部','主席团','运营部','销售部'];
child[1] = ['职员','组长','主任','经理'];
function linkage(m){
    one.length = 1;
    two.length = 1;
    //遍历生产option选项
    if(m<=1){
        for (i = 0; i < child[0].length; i++) {

            //创建一个option 把数据存储在option
            op = new Option(child[0][i],i);
            //把带有数据的option 添加到第二个select
            one.add(op);
        };
        for ( i = 0; i < child[1].length; i++) {

            //创建一个option 把数据存储在option
             op = new Option(child[1][i],i);
            //把带有数据的option 添加到第二个select
            two.add(op);
        };
    }
    else if(m==2){
        for ( i = 0; i < child[1].length; i++) {

             op = new Option(child[1][i],i);

            one.add(op);
        };
        for ( i = 0; i < child[1].length; i++) {

             op = new Option(child[1][i],i);

            two.add(op);
        };
    }
    else {
        for (  i = 0; i < child[0].length; i++) {

             op = new Option(child[0][i],i);

            one.add(op);
        };
        for ( i = 0; i < child[0].length; i++) {

             op = new Option(child[0][i],i);

            two.add(op);
        };
    }
}