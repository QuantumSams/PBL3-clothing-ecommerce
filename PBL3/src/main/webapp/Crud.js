
    const imageUpload = document.getElementById('image-upload');
    const previewImage = document.getElementById('preview-image');
    imageUpload.addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            previewImage.src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});
    function addItem(i) {
        const list = document.getElementById(i);
        const newItem = document.createElement("div");
        const newInput = document.createElement("input");
        const newButton = document.createElement("button");
        newButton.textContent = "X";
        newButton.className = "deleteItem";
        let j = "#"+i;
        newButton.onclick = removeItem(j);
        newItem.appendChild(newInput);
        newItem.appendChild(newButton);
        newItem.className = "inputSize";
        list.appendChild(newItem);
    }
    function acceptChange(i,j){
        const btn = document.getElementsByClassName(i);
        const form = document.querySelector(j);
        if(form.style.display == "none"){
            btn.textContent = "Hoàn tất";
            form.style.display = "block";
        }
        else{
            const inputElements = document.querySelectorAll("#itemListSize input");
            const inputValues = Array.from(inputElements).map(input => input.value); 	
            btn.textContent = "Chỉnh sửa";
            form.style.display = "none";
        }
    }
    function removeItem(i){
        const list = document.querySelector(i);
        list.addEventListener("click", function(event) {
        if (event.target.tagName === "BUTTON") {
            list.removeChild(event.target.parentNode);
        }
    });
    }
    function createTable(){
        const inputElements1 = document.querySelectorAll("#itemListSize input");
        const inputColor = Array.from(inputElements1).map(input => input.value);
        const inputElements2 = document.querySelectorAll("#itemListColor input");
        const inputSize = Array.from(inputElements2).map(input => input.value);
        let count = 0;
        console.log(inputColor);
        console.log(inputSize);
        let table = document.getElementById('myTable');
        table.innerHTML = "";
        for(let i = 0; i<inputColor.length; i++){
            for(let j = 0; j< inputSize.length; j++){
            	count=count+1;
                let row = `<tr>
                    <td>${count}</td>
                    <td>${inputColor[i] +" "+ inputSize[j]}</td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    </tr>`
                	table.innerHTML +=row;
                }
            }
    }