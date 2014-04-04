
// 操作页面跳转
$(function()
{
	var History = (function(pkg)
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
		return History;
	})();

	var extension = '.html';// 便于测试
	var history = new History();

	function load_page(url)
	{
		// 判断是否已经有后缀
		if(extension)
		if((url.indexOf(extension) + extension.length) != url.length)
		{
			url = url + extension;
		}

		console.info("load page ", url)
		$('#center-part').load(url);
		history.add(url);
	}
	function refresh_nav_button_state()
	{

	}
	function doPageUrl(target)
	{
		var $this = $(target);
		var url;

		if($this.is('a.page-url'))
			url = $this.attr('href');

		if(! url)
			url = $this.data('page-url');

		load_page(url);

		// 如果是在左侧的菜单栏选择的,则设置 active
		var $sidebar = $this.closest('.sidebar');
		if($sidebar.size() > 0)
		{
			$sidebar.find('.active').removeClass('active');
			$this.closest('li').addClass('active');
		}
	}

	// 点击跳转到 url
	$(document).on('click','[data-page-url],a.page-url',function(e)
	{
		e.preventDefault();
		e.stopPropagation();

		doPageUrl(e.target);
	});

	// 页面导航跳转
	$(document).on('click','[data-page-nav],[class*=page-nav]',function(e)
	{
		var $this = $(e.target);
		var action = $this.data('page-nav');
		if(!action)
		{
			var matches = $this.attr('class').match(/page-nav-([^\b]+)/);
			if(matches)
				action = matches[1];
		}

		var url = null;
		switch(action)
		{
			case 'forward':
				url = history.forward();
				break;
			case 'backward':
				url = history.backward();
				break;
			case 'refresh':
				url = history.current();
				break;
			default :
				console.error("未定义的导航动作 "+action+" 在标签 ", this);
				return;
		}
		if(!! url)
			load_page(url);
	});

	// 显示当前激活的页面
	$sidebar = $('.sidebar ');
	$sidebar.find('.active a.page-url').trigger('click');

	// 避免每次都被关闭
	$sidebar.find('.dropdown-menu').on('click',function(e)
	{
		e.preventDefault();
		e.stopPropagation();
	}).on('click','[data-page-url],a.page-url',function(e)
	{
		doPageUrl(e.target);
	});
});


// tree 操作实现
$(function ()
{
	$('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
	$('.tree li.parent_li > span').on('click', function (e)
	{
		var children = $(this).parent('li.parent_li').find(' > ul > li');
		if (children.is(":visible"))
		{
			children.hide('fast');
			$(this).attr('title', 'Expand this branch').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
		} else
		{
			children.show('fast');
			$(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
		}
		e.stopPropagation();
	});
});

// table 里的全选实现
$(function()
{
	// 点击全选或取消全选
	$(document).on("change",'th > .checkbox',function()
	{
		var $this = $(this);
		var index = $this.closest("th").index();
		$this.closest('table')
			.find('tr td:nth-of-type('+(index + 1)+') [type=checkbox]')
			.prop('checked',$this.find('[type=checkbox]').is(':checked'))
	});

	// 检查是否全部选中了
	$(document).on("change",'td > .checkbox',function()
	{
		var $this = $(this);
		var index = $this.closest("td").index();
		var $checkboxes = $this
			.closest('table')
			.find('tr td:nth-of-type('+(index + 1)+') [type=checkbox]');

		var allCheck = $checkboxes.size() == $checkboxes.filter(':checked').size();

		$this.closest('table')
			.find('th:nth-of-type('+(index + 1)+') [type=checkbox]')
			.prop('checked',allCheck)
	});
});