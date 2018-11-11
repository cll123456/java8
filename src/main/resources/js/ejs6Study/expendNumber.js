//如果要将0b和0o前缀的字符串数值转为十进制，要使用Number方法
console.log(Number('0b111'));//7
console.log(Number('0o10'));//8

//Number.isFinite(), Number.isNaN()
console.log(Number.isFinite(12));//true
console.log(Number.isFinite(0.34343));//true
console.log(Number.isFinite(-2));//true  如果参数类型不是数值，Number.isFinite一律返回false。

console.log(Number.isNaN(NaN));//true isNaN的作用是判断值是否为非数字
console.log(Number.isNaN('nan'));// false 如果参数类型不是NaN，Number.isNaN一律返回false。

//Number.parseInt(), Number.parseFloat()
console.log(Number.parseInt('23.5475')); //23
console.log(Number.parseFloat('34.00397473747', "str")); //34.00397473747
console.log(Number.isInteger(23));//true
console.log(Number.isInteger(2.00000000000000000000000000));//true

// Number.EPSILON 计算精度比较小的浮点型数据
console.log(Number.EPSILON = Math.pow(2, -9));//0.001953125

//Number.MAX_SAFE_INTEGER和Number.MIN_SAFE_INTEGER这两个常量 计算上限和下限
console.log(Number.MAX_SAFE_INTEGER = Math.pow(2, 53) - 1); //9007199254740991
console.log(Number.MIN_SAFE_INTEGER = Math.pow(-2, 53) + 1); //-9007199254740991

//c
function trusty(left, right, result) {
    if (
        Number.isSafeInteger(left) &&
        Number.isSafeInteger(right) &&
        Number.isSafeInteger(result)
    ) {
        return result;
    }
    throw new RangeError('Operation cannot be trusted!');
}

console.log(trusty(134554, 4345345254353, 134554 - 4345345254353));

// Math.trunc() 用于除去小数部分
console.log(Math.trunc(3.49348849));//3
console.log(Math.trunc(89.));//89


//ejs6函数的变化
function choose({x, y = 5} = {}) {
    console.log(x, y);
}

choose({x: 1});
choose(); //会指定一个空对象给他 undefined 5


function fetch(url, {body = '', method = 'GET',} = {}) {
    console.log(method);
}

fetch('http://example.com', {}); //GET

function sum(...values) {
    let addition = 0;
    for (let i of values) {
        addition += i;
    }
    return addition;
}

console.log(sum(3, 4, 6, 5, 8, 9));


const sortNumber = (...number) => number.sort();
console.log(sortNumber(1, 3, 5, 76, 2, 34, 234, 63543, '我', 'cll', 'be', '帅'));// [ 1, 2, 234, 3, 34, 5, 63543, 76, 'be', 'cll', '帅', '我' ]
console.log(sortNumberWithArgument(5, 1, 5, 355, 35, 23, 78, 0, 'able', 'sell', 'cll')); //[ 0, 1, 23, 35, 355, 5, 5, 78, 'able', 'cll', 'sell' ]

function sortNumberWithArgument() {
    return Array.prototype.slice.call(arguments).sort();
}

//按数字排序，不是按大小,然后字母，最后按中文的拼音排序

function push(array, ...items) {
    items.forEach(function (item) {
        array.push(item);
    });
    return Array.from(new Set(array));

}

let arr = [];
console.log(push(arr, 2, 4, 7, 3, 8, 38, 3));
;

function pushArray(arr, ...arr2) {
    const res = new Map();
    let arrs;
    arr2.forEach(function (item) {
        item.forEach(function (number) {
            arr.push(number);
        })
    })
    arrs = arr.filter((a) => !res.has(a) && res.set(a, 1));
    return arrs;
}

let arr1 = [1, 4, 2];
let arr2 = [4, 5, 6];
let arr3 = [5, 7, 9, 0, 2];
console.log(pushArray(arr1, arr2, arr3));


function insert(value) {
    return {
        into: function (array) {
            return {
                after: function (afterValue) {
                    array.splice(array.indexOf(afterValue) + 1, 0, value);
                    return array;
                }
            }
        }
    }
}

console.log(insert(3).into([2, 4]).after(4));

//箭头函数表达，=>指的是返回的东西
let add = (value) => ({
    into: (array) => ({
        after: (afterValue) => {
            array.splice(array.indexOf(afterValue) + 1, 0, value);
            return array;
        }
    })
});
console.log(add(4).into([2, 43, 65]).after(65));

//前一个函数的输出等于后一个函数的输入

const pipeLine = (...input) => val => input.reduce((a, b) => b(a), val);
const p1 = m => m + 1;
const p2 = m => m * 2;
const goto = pipeLine(p1, p2);
console.log(goto(10));

console.log(p2(p1(4)));

//双冒号运算符

//阶层
function jiecheng(n) {
    if (1 === n) return 1;
    return n * jiecheng(n - 1);
}

console.log(jiecheng(4));


//数组扩展
let arrays = [...[], 3];
console.log(arrays.length);

let arr6 = [2, 4, 5, 6, 7];
let arr4 = [6, 4, 3, 6];
let arr5 = [8, 9, 0, 0, 7];
console.log(arr5);
console.log(Array.from(new Set(arr6.concat(arr4, arr5))).sort());
//合并数组
console.log(Array.from(new Set([...arr6, ...arr4, ...arr5])).sort());

//扩展运算符还可以将字符串转为真正的数组。
console.log([..."hello,world"]);
//扩展运算符内部调用的是数据结构的 Iterator 接口，
// 因此只要具有 Iterator 接口的对象，都可以使用扩展运算符，比如 Map 结构。
let maps = new Map([
    [1, 'one'],
    [2, 'two'],
    [3, 'three']
]);
console.log([...maps.values()]);
//generator
const go = function* () {
    yield 1;
    yield 2;
    yield 3;
};
console.log([...go()]);

//Array.from() 将数组对象转换成数组
let arrayLike = {
    0: 'a',
    1: 'b',
    2: 'c',
    length: 3
};
console.log(Array.from(arrayLike));//length不能少，否则没有数组长度，或者长度为0

//Array.of方法用于将一组值，转换为数组。
console.log(Array.of(1, 2, 4, 3, 5));
console.log(Array.of(2,4).length);

//数组实例的 copyWithin()
// console.log([2, 3, 4, 8, 34, 54].copyWithin(2,4,2));

//flat flatMap
[1,2,[2,3]].flat();

