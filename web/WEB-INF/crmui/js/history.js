
window.pkg = {};
(function(pkg)
{
	function History()
	{
		this.position = -1;// 在 array 中的索引
		this.maxHisthory = 20;
	}
	function backward()
	{
		return this.canBackward()? this[--this.position]: null;
	}
	function forward()
	{
		return this.canForward()? this[++this.position]: null;
	}
	function canBackward()
	{
		// current 有可能 空串,0, null, false,undefined
		// 目前只考虑正确的
		return !!this[this.position-1];
	}
	function canForward()
	{
		return !!this[this.position+1];
	}
	function hasCurrent()
	{
		return !!this[this.position];
	}
	function current()
	{
		return this[this.position];
	}
	function max(num)
	{
		if(num === undefined)
			return this.maxHisthory;
		else
			return this.maxHisthory = num;
	}
	function add(url)
	{
		// 相同的url 不重复添加
		if(!url || url == this.current())
			return false;
		// 如果当前位置不是在最后 则把后面的截取掉
		if((this.position + 1) != this.length)
			this.splice(- 1,this.length-this.currenrt);

		//this[ ++this.position] = url;
		this.position ++;
		this.push(url);

		// 达到了最大值,弹出前面的
		if(this.length > this.max())
			this.shift();
		return true;
	}
	function asArray()
	{
		return this.slice(0);
	}

	History.prototype = [];
	History.prototype.backward=backward;
	History.prototype.forward=forward;
	History.prototype.add=add;
	History.prototype.asArray=asArray;
	History.prototype.hasCurrent=hasCurrent;
	History.prototype.current=current;
	History.prototype.canForward=canForward;
	History.prototype.canBackward=canBackward;
	History.prototype.max=max;

	if(!!pkg)
		pkg['History'] = History;
})(pkg || (pkg = {}));

var h = new pkg.History()
h.add(1);
h.add(2);
h.add(0);// not work
h.add(3);
h.add(null);// not work

console.assert(h.current() == 3,"current 1");
console.assert(h.backward() == 2,"backward 1");
console.assert(h.forward() == 3,"forward 1");
console.assert(h.current() == 3,"current 2");
console.assert(h.canForward() === false,"current 2");
console.assert(h.forward() === null,"forward null");
console.assert(h.backward() == 2,"backward 2");
console.assert(h.backward() === 1,"backward 3");
console.assert(h.backward() === null,"backward null");
