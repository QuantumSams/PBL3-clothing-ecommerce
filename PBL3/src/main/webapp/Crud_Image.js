const fileInput = document.getElementById('fileInput');
const imgElement = document.getElementById('img');

fileInput.addEventListener('change', function(event) {
  	const file = event.target.files[0];

  	if (file) {
    	const reader = new FileReader();

    	reader.onload = function(event) {
      	imgElement.src = event.target.result;
    	};

    	reader.readAsDataURL(file);
  	}
}); 