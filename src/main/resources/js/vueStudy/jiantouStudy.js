//箭头函数的学习  ,不具备this,arguments

function flatten(arr) {
	return arr.reduce((result, item) => {
		return Array.from(new Set(result.concat(Array.isArray(item) ? flatten(item) : item)));
	}, []);
}

console.log(flatten([[1, 2], [3, 4], 34, 3, , [1, [12, 233,], 2]]));


let flats = arr =>
	arr.reduce((result,item)=>
		Array.from(new Set(result.concat(Array.isArray(item)?flats(item):item))),[])
console.log(flats([[1, 2], [3, 4], 34, 3, , [1, [12, 233,], 2]]));


