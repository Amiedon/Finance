// JavaScript Document
<script type="text/javascript">
	 function selected(x){//点击标签的js脚本
		var labelvaule=document.getElementById("labelvalue");
		var labellist=document.getElementsByTagName("li");
		labelvalue.innerHTML=labellist[x].innerHTML;
	}
	function consumeselect(){
		var sel=document.getElementsByTagName("select")[0];
		var labelselect=document.getElementById("labelvalue");
		if(sel.name=="i")
		{
			labelselect.style.display="inline";
			sel.name="c";
		}	
		else
		{
			labelselect.style.display="none";
			sel.name="i";
		}
	}
	function check(){
		var inputs=document.getElementsByTagName("input");
		if(inputs[0].value==""|| inputs[1].value=="")
			alert("“起止时间”不能为空");
		}
</script>