function call(){ //to check image size
	
	
    var uploadField = document.getElementById("inputGroupFile02");

 

    if(uploadField.files[0].size> 10000000){
        alert("File is too big");
        uploadField.value="";
    }
}