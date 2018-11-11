//let 用于数组，一一对应
let [a, b, c] = [1, 2, 3];
console.log(a, b, c);
let [e, [f], g] = [2, [2, 3, 4], 8];
console.log(e, f, g);
let [bar, foo] = [1];
console.log("bar=" + bar, "foo=" + foo);
let [x, y, z] = new Set(['a', 'b', 'c']);
console.log(x, y, z);

function* fibs() {
    let a = 0;
    let b = 1;
    while (true) {
        yield a;
        [a, b] = [b, a + b];
    }
}

let [first, second, third, fourth, fifth, sixth] = fibs();
console.log(first, second, third, fourth, fifth, sixth)

function ff() {
    console.log('aaa');
}

let [zx = ff()] = [1];
console.log(zx);

let xx;
if ([1][0] === undefined) {
    xx = ff();
    console.log("xy=" + xx);
} else {
    xx = [1][0];
    console.log("xx=" + xx);
}
//let可以用与对象
let {barr, fooo} = {fooo: "aaa", barr: "bbb"};
console.log("barr=" + barr, "fooo" + fooo)

let obj = {first: "hello", last: "world"};
let {first: fff, last: ll} = obj;
console.log("fff=" + fff, "ll=" + ll);

let object = {
    p: [
        'Hello',
        {y: 'World'}
    ]
};
let {p, p: [xxxx, {yyyy}]} = object;
console.log("xxxx=" + xxxx, "yyyy=" + yyyy, "p=" + p);

let arr = [1, 2, 3];
let {0: first1, [arr.length - 1]: last2, 1: seconds} = arr;
console.log("first1=" + first1, "last2=" + last2, "second=" + seconds);

//字符串的解构赋值

const [q1, w1, e1, r1, t1] = "Hello,world";
console.log(q1, w1, e1, r1, t1)

const {length: len} = "cll is a handsome boy";
console.log("len=" + len);

//数值和布尔值的解构赋值
let {toString: ss} = 123;
ss === Number.prototype.toString;
console.log("ss=" + ss);
let {toString: str} = true;
str === Boolean.prototype.toString;
console.log("str=" + str);

//函数参数的解构赋值
function add([x, y]) {
    return x + y;
}

console.log(add([1, 2]));

console.log("a,b的和为" + [[1, 2], [3, 4]].map(([a, b]) => a + b));

function move({x, y} = {x: 1, y: 30}) {
    return [x, y];
}

console.log(move({x: 3, y: 8}));
console.log(move({x: 3}));
console.log(move({}));
console.log(move());

let arr1 = [undefined, undefined, 3];
console.log("arr1里面有" + arr1.map((x = "yes") => x))

//交换值
let [x1, y1] = [1, 3];
[x1, y1] = [y1, x1];
console.log("x1=" + x1, "y1=" + y1);

//返回一个或多个对象
//1.返回一个数组
function example() {
    return [1, 2, 3, 4];
}

let [z1, x11, c1, v1] = example();
console.log(z1, x11, c1, v1);

//2.放回多个对象
function example1() {
    return {
        ten: 123,
        nine: 234,
        eight: 345
    }
}

let {ten, nine, eight} = example1();
console.log(ten, nine, eight)

//提取json
let jsonData = {
    id: "9089849485958",
    type: "get",
    status: "Ok",
    data: [123, 566, 234]
}
let {id, type, status, data: number} = jsonData;
console.log(id, type, status, number);

//遍历map
const map = new Map();
map.set("hello","world");
map.set("cll","a good boy");
for(let[key,value] of map){
    console.log(key+" is "+value);
}
map.forEach((a,b)=>console.log(b))
