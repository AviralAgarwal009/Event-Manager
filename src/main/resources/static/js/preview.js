var toggleEdit=true;

function edit()
{
    
    var temp = document.getElementById("edit");
    if(toggleEdit)
    {
        temp.innerHTML = "Save";
        var template="<i class='fa fa-save' >"+
                    "</i>";
        temp.innerHTML += template;
        document.getElementById("user").removeAttribute("readonly");
        document.getElementById("phone").removeAttribute("readonly");
        document.getElementById("email").removeAttribute("readonly");
        document.getElementById("tickets").removeAttribute("readonly");
        document.getElementById("regType").removeAttribute("disabled");
        toggleEdit=false;
    }
    else
    {
        temp.innerHTML = "Edit";
        var template="<i class='fa fa-edit' >"+
                    "</i>";
        temp.innerHTML+=template;
        document.getElementById("user").readOnly=true;
        document.getElementById("phone").readOnly=true;
        document.getElementById("email").readOnly=true;
        document.getElementById("regType").disabled=true;
        document.getElementById("tickets").readOnly=true;
        document.getElementById("email").readOnly=true;
        toggleEdit=true;
    }
}


function checkSave(){
	 document.getElementById("regType").removeAttribute("disabled");  
    if(!toggleEdit){
        document.getElementById("user").readOnly=true;
        document.getElementById("phone").readOnly=true;
        document.getElementById("email").readOnly=true;
       
        alert("Changes Saved Automatically");
    }
}