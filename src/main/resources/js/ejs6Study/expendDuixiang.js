//对象的扩展
let birthday = '2010/10/22';
let person = {
    birthday,
    name: "张三",
    age: "18",
    hello() {
        console.log("my name is " + this.name + "、I already " + this.age + ",will take a party" + this.birthday)
    }
};
console.log(person.hello());

//Object.assign方法用于对象的合并，将源对象（source）的所有可枚举属性，复制到目标对象（target）。
const a = {a: 1};
const b = {b: 2};
const c = {c: 3};
console.log(Object.assign({}, a, b, c));


let {keys, values, entries} = Object;
let obj = {a: 1, b: 2, c: 3};

for (let key of keys(obj)) {
    console.log(key); // 'a', 'b', 'c'
}

for (let value of values(obj)) {
    console.log(value); // 1, 2, 3
}

for (let [key, value] of entries(obj)) {
    console.log([key, value]); // ['a', 1], ['b', 2], ['c', 3]
}


//set and map
const set = new Set();
[1, 2, 3, 4, , 53, 2,].forEach((x) => set.add(x));
set.forEach(x => console.log(x))

const s = new Set([1, 2, 4, 2, 2, , 3, 4, 4, , 2]);
[...s].forEach(a => console.log(a));
console.log("s的大小是：" + s.size, "，s的length是：" + s.length + s);

let sets = new Set([33, 4, 2, 4, 2, 4, 2, 4, , 2, 4, 2, , 2]);
console.log(sets = new Set([...sets].filter(a => (a % 2 == 0))));
;

//并集
let union = [...sets, ...s];
console.log("并集是：" + union);
//交集
let jiaoJi = [...sets].filter(a => s.has(a));
console.log("交集是：" + jiaoJi);
//差集
let chaJi = [...sets].filter(a => !s.has(a));
console.log("差级是：" + chaJi);


const map0 = new Map()
    .set(1, 'a')
    .set(2, 'b')
    .set(3, 'c');

const map1 = new Map(
    [...map0].filter(([k, v]) => k < 3)
);
// 产生 Map 结构 {1 => 'a', 2 => 'b'}

const map2 = new Map(
    [...map0].map(([k, v]) => [k * 2, '_' + v])
);
// 产生 Map 结构 {2 => '_a', 4 => '_b', 6 => '_c'}


//proxy
var proxy = new Proxy({}, {
    get: function (target, handler) {
        return 35;
    }
})
console.log("代理的时间：" + proxy.time);
console.log("代理的名称：" + proxy.name);
console.log("代理的标题：" + proxy.title);

var p = new Proxy(person, {
    get: function (target, property) {
        if (property in target) {
            return target[property];
        } else {
            throw new ReferenceError(property + " is not define or not exist.");
        }
    }
});
console.log(p.name);
// console.log(p.sex); 这里报错

//react
var objss = {
    foo: '1',
    bar: '2',
    four: "4",
    get baz() {
        return this.foo + this.bar + this.four;
    }
}
console.log(Reflect.get(objss, 'foo'));
console.log(Reflect.get(objss, 'four'));
console.log(Reflect.get(objss, 'baz'));

const args = [2, 3, 23, 34, 3432, 43, 243432, 4];
console.log(Reflect.apply(Math.max, Math, args));


const obseverable = new Set();
const observer = fn => obseverable.add(fn);
const ass = obj => new Proxy(obj, {setterest});

function setterest(target, key, value, receiver) {
    const result = set(target, key, value, receiver);
    obseverable.forEach(observer => observer());
    return result;
}

const people = ass({
    name: "cll",
    age: 23,
    birthday: "2018/02/23"
});

function printf() {
    console.log(`${people.name},${people.birthday},${people.age}`);
}

// people.name = "cll"
observer(printf());


//promise
let promise = new Promise(function(resolve, reject) {
    console.log('Promise');
    resolve();
});

promise.then(function() {
    // console.log('resolved.');
});

console.log('Hi!');


//异步加载图片
function loadImage(url){
    return new Promise(function (resolve,reject) {
        const img = new Image();
        img.onload = function () {
            resolve(img);
        };
        img.onerror = function () {
            reject(new Error("the image url error or invalid"+url));
        }
        img.src = url;
    });
};

// const p1 = new Promise((resolve, reject) => {
//     resolve('hello');
// })
//     .then(result => result)
//     .catch(e => e);
//
// const p2 = new Promise((resolve, reject) => {
//     throw new Error('报错了');
// })
//     .then(result => result)
//     .catch(e => e);
//
// Promise.all([p1, p2])
//     .then(result => console.log(result))
//     .catch(e => console.log(e));



function getNumber(){
    var p = new Promise(function(resolve, reject){
        //做一些异步操作
        setTimeout(function(){
            var num = Math.ceil(Math.random()*10); //生成1-10的随机数
            if(num<=5){
                resolve(num);
                console.log("咱们结婚吧，resolve:"+num);
            }
            else{
                reject('数字太大了');
                console.log("reject:"+num);
                getNumber();
            }
        }, 2000);
    });
    return p;
}

getNumber()
    .then(
        function(data){
            console.log('resolved');
            console.log(data);
        },
        function(reason, data){
            console.log('rejected:'+data);
            console.log(reason);
        }
    );





//generator
function* g() {
    yield 1;
    console.log('throwing an exception');
    throw new Error('generator broke!');
    yield 2;
    yield 3;
}

function log(generator) {
    var v;
    console.log('starting generator');
    try {
        v = generator.next();
        console.log('第一次运行next方法', v);
    } catch (err) {
        console.log('捕捉错误', v);
    }
    try {
        v = generator.next();
        console.log('第二次运行next方法', v);
    } catch (err) {
        console.log('捕捉错误', v);
    }
    try {
        v = generator.next();
        console.log('第三次运行next方法', v);
    } catch (err) {
        console.log('捕捉错误', v);
    }
    console.log('caller done');
}

log(g());


// var cars = [{ make: 'audi', model: 'r8', year: '2012' }, { make: 'audi', model: 'rs5', year: '2013' }, { make: 'ford', model: 'mustang', year: '2012' }, { make: 'ford', model: 'fusion', year: '2015' }, { make: 'kia', model: 'optima', year: '2012' }],
//     result = cars.reduce(function (r, a) {
//         r[a.make] = r[a.make] || [];
//         r[a.make].push(a);
//         return r;
//     }, Object.create(null));
//
// console.log(result);
