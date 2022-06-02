const getSurveyList = () => {
    const listUrl = 'http://localhost:8080/survey';
    const listContainer = '#surveyList';
    const total = '#total';
    let html = '';

    $(listContainer).html(html);
    $.get(listUrl, (response) => {
        $(total).html(response.length);
        response.map((item) => {
            html += `
            <li class="list-group-item survey-list-item">
                <p class="m-0 fixed-width">Enviada por: <span class="fw-bold">${item.nombre}</span></p>
                <span class="text-success">${item.fecha}</span>
                <i class="bi bi-trash2-fill icon-list" onclick="deleteItem(${item.id})"></i>
            </li>
            `;
        });

        $(listContainer).html(html);
    });
};

export default getSurveyList;
