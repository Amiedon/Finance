// JavaScript Document
 function setImagePreview(docObj,localImagId,imgObjPreview)
    {

        var name=docObj.value;
        var type=name.split(".");
        type=type[type.length-1];
        if("jpg"!=type &&"png"!=type &&"jpeg"!=type&&"gif"!=type&&"JPG"!=type){
            alert("��������ͣ���ѡ��ͼƬ");
            document.getElementById("txtSrc").value=null;//��ֹ����ͼƬ�����ϴ�
            return ;
        }

        if(docObj.files && docObj.files[0])
        {

            //alert("hello"+docObj.files[0]);
            //���7���ϰ汾�����������getAsDataURL()��ʽ��ȡ����Ҫһ�·�ʽ
            document.getElementById("imgDiv").style.display="block";
            document.getElementById("img").src= window.URL.createObjectURL(docObj.files[0]);
        }
        else
        {
            //IE�£�ʹ���˾�
            docObj.select();
            var imgSrc = document.selection.createRange().text;

            //�������ó�ʼ��С
            localImagId.style.width = "300px";
            localImagId.style.height = "200px";

            //ͼƬ�쳣�Ĳ�׽����ֹ�û��޸ĺ�׺��α��ͼƬ
            try
            {
                localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            }
            catch(e)
            {
                alert("���ϴ���ͼƬ��ʽ����ȷ��������ѡ��!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }

function check()
{
	var nickname=document.getElementById("nickname");
	var consumetarget=document.getElementById("consumetarget");
	alert(nickname.id);
	alert(consumetarget.id);
}