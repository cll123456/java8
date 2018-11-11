//foreach
let arr = [1];
arr.b = '100';
for (let i of arr) {//编程式,不能遍历对象，能return
	console.log(i);
}
//foreach 不支持return
arr.forEach(function (iteam) {//声明式
	console.log(iteam);
});

for (let key in arr) {//key变成字符串,
	console.log(typeof key);
}

let obj = {ping: '猪', dog: '够'};//Object.keys 支持遍历对象
for (let i of Object.keys(obj)) {
	console.log(i);
}

//filter 是否操作原数组：no  返回结果：得到新数组 ，
// 回掉函数的返回结果：如果返回true，表示放到新数组

console.log([1, 2, 4].filter(a => a > 1 && a < 4));

//map 将原有的数组映射成新数组，不操作原数组

console.log([1, 2].map(a => `<li>${a}</li>`).join(''));

//find
console.log([1, 2, 3, 22, 4].find((a, b) => a.toString().indexOf(2) > -1));

//some 找到返回true, every 找false 返回false
console.log([1, 2].some((a, b) => a.toString().indexOf(1) > -1));


//reduce 4个参数  返回叠加后的结果
//prev 代表数组第一项，next代表数组的第二项
[1, 2, 3].reduce(function (prev, next, index, item) {
	console.log(arguments);
	console.log(prev, next);
});

let sum = [{price: 20, count: 2}, {price: 20, count: 3}, {price: 20, count: 4}].reduce((prev, next) => (prev + next.price * next.count),0);
console.log("sum的和：" + sum);


// function getCurrentMonthFirst(){
// 	var date=new Date();
// 	date.setDate(1);
// 	return date;
// }
//
// console.log(getCurrentMonthFirst());
//扁平化数组
console.log([[1, 2], [3, 4], 34, 3, , [1, 2]].reduce((a, b) => a.concat(b)));

//扁平化数组实现去重
const res = new Map();
console.log([[1, 2], [3, 4], 34, 3, , [1, [12, 233,], 2]].reduce((a, b) => (a.concat(b))).filter((f) => !res.has(f) && res.set(f, 1)));


function flatten(arr) {
	return arr.reduce((result, item)=> {
		return Array.from(new Set( result.concat(Array.isArray(item) ? flatten(item) : item)));
	}, []);
}

console.log(flatten([[1, 2], [3, 4], 34, 3, , [1, [12, 233,], 2]]));


function flattens(arr) {
	while(arr.some(item=>Array.isArray(item))) {
		arr = [].concat(...arr);
	}
	return Array.from(new Set(arr));
}

console.log(flattens([[1, 2], [3, 4], 34, 3, , [1, [12, 233,], 2]]));
