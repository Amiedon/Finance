// JavaScript Document
<script type="text/javascript">
	 function selected(x){//�����ǩ��js�ű�
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
			alert("����ֹʱ�䡱����Ϊ��");
		}
</script>