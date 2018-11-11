//拓展字符串

let s = '𠮷a';
console.log(s.codePointAt(0).toString(16));
console.log(s.codePointAt(2).toString(16));
console.log(String.fromCharCode(0x20BB7));
// ஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷஷ
console.log(String.fromCodePoint(0x20BB7));
//遍历字符串
for (let code of "foo") {
    console.log(code);
}

let hello = "Hello,cll !";
console.log(hello.includes('o'));
console.log(hello.endsWith('!'));
console.log(hello.startsWith('H'));
console.log(hello.indexOf('l'));//求出的是‘l’的下标

//repeat
console.log('x'.repeat(2.98977666));//小数的话向下取整

//padStart()，padEnd()头部添加和尾部添加
console.log('x'.padStart(3, "cll is a handsome"));//clx 前面的参数是表示把字符串增加到多长
console.log('e'.padEnd(19, 'love')); //elovelovelovelovelo

//模板字符串
function fn() {
    return "Hello World";
}

console.log(`foo ${fn()} bar`);
console.log(`Hello ${'World'}`);
// let msg = `Hello, ${place}`;
// console.log(msg); 报错，没有定义  place

const data = [
    {first: '<Jane>', last: 'Bond'},
    {first: 'Lars', last: '<Croft>'},
];
const tmpl = addrs => `
  <table>
  ${addrs.map(addr => `
    <tr><td>${addr.first}</td></tr>
    <tr><td>${addr.last}</td></tr>
  `).join('')}
  </table>
`;
console.log(tmpl(data));

//引用模板字符串本身
//第一种写法
let str = 'return' + '`hello , ${name}!how are you`';
let func = new Function('name', str);
console.log(func("cll"));
//第二种写法
let secondStr = '(name) => `${name},what matter`';
let result = eval.call(null, secondStr);
console.log(result("小明"));

let a = 5;
let b = 10;

function tag(arr, v1, v2, v3) {
    console.log("arr[0]=" + arr[0]);
    console.log("arr[1]=" + arr[1]);
    console.log("arr[2]=" + arr[2]);
    console.log("v1=" + v1);
    console.log("v2=" + v2);
    console.log("v3=" + v3);

    return "OK";
}

tag`Hello ${ a + b } world ${ a * b} ! ${b - a}`;
// tag(['Hello ', ' world ', ''], 15, 50);

//js用函数passthru把原来的参数拼接回去
let total = 30;
let message = passthru`calculate the total is ${total},if include the tax is ${total * 1.05}`;

function passthru(arg) {
    let result = '';
    let i = 0;
    while (i < arg.length) {
        result += arg[i++];
        if (i < arguments.length) {
            result += arguments[i];
        }
    }
    return result;
}

console.log(message);

let messages = passthrus`I have a lot of money,it total about ${total},if I take it to the bank and i have ${total * 1.09}.`;

function passthrus(arg, ...values) {
    let output = "";
    let index;
    for (index = 0; index < values.length; index++) {
        output += arg[index] + values[index];
    }
    output += arg[index];
    return output;
}

console.log(messages);


