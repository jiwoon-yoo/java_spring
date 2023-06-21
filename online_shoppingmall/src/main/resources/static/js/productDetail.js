const sizeSelect = document.getElementById('sizeSelect');
const quantitySelect = document.getElementById('quantitySelect');

sizeSelect.addEventListener('change', function() {
    const selectedSize = sizeSelect.value;
    
    // Access the values of hidden inputs
    const quantityS = document.getElementById('quantityS').value;
    const quantityM = document.getElementById('quantityM').value;
    const quantityL = document.getElementById('quantityL').value;
    
    // Update the quantity options based on the selected size
    if (selectedSize === 'S') {
        console.log('Size S selected');
        // Set quantity options for size S
        quantitySelect.innerHTML = `
            <option ${quantityS < 1 ? 'disabled' : ''}>1</option>
            <option ${quantityS < 2 ? 'disabled' : ''}>2</option>
            <option ${quantityS < 3 ? 'disabled' : ''}>3</option>
            <option ${quantityS < 4 ? 'disabled' : ''}>4</option>
            <option ${quantityS < 5 ? 'disabled' : ''}>5</option>
        `;
    } else if (selectedSize === 'M') {
        console.log('Size M selected');
        // Set quantity options for size M
        quantitySelect.innerHTML = `
            <option ${quantityM < 1 ? 'disabled' : ''}>1</option>
            <option ${quantityM < 2 ? 'disabled' : ''}>2</option>
            <option ${quantityM < 3 ? 'disabled' : ''}>3</option>
            <option ${quantityM < 4 ? 'disabled' : ''}>4</option>
            <option ${quantityM < 5 ? 'disabled' : ''}>5</option>
        `;
    } else if (selectedSize === 'L') {
        console.log('Size L selected');
        // Set quantity options for size L
        quantitySelect.innerHTML = `
            <option ${quantityL < 1 ? 'disabled' : ''}>1</option>
            <option ${quantityL < 2 ? 'disabled' : ''}>2</option>
            <option ${quantityL < 3 ? 'disabled' : ''}>3</option>
            <option ${quantityL < 4 ? 'disabled' : ''}>4</option>
            <option ${quantityL < 5 ? 'disabled' : ''}>5</option>
        `;
    }
});







  function validateForm(event) {
    event.preventDefault(); // Prevent the default form submission

    var sizeSelect = document.getElementById("sizeSelect");
    var selectedSize = sizeSelect.value;

    if (selectedSize === "") {
      alert("Please select a size option.");
      return false; // Prevent form submission
    }

    setTimeout(function() {
      alert("the item has been added into the cart"); 
      event.target.submit(); // Manually submit the form
    }, 1000);

    return false; // Prevent form submission
  }
