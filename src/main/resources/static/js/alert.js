const alertPlaceholder = document.getElementById('liveAlertPlaceholder');

const appendAlert = (message, type, delay) => {
    const wrapper = document.createElement('div');
    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('');

    alertPlaceholder.appendChild(wrapper);

    setTimeout(() => {
        wrapper.remove();
    }, delay);
};

const alertTrigger = document.getElementById('liveAlertBtn');
if (alertTrigger) {
    alertTrigger.addEventListener('click', (event) => {
        event.preventDefault();

        const form = document.getElementById('expenseForm');
        if (form.checkValidity()) {
            // TO WYMAGA POPRAWY, ALERT WYSWIETLA SIE PRZED ERRORAMI
            // appendAlert('Wydatek został dodany!', 'success', 500);
             setTimeout(() => {
                 form.submit();
             }, 300);
        } else {
            Array.from(form.elements).forEach(element => {
                if (!element.checkValidity()) {
                    element.classList.add('is-invalid');
                }
            });
        }

    });
}
