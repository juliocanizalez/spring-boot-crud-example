const surveyConfig = () => {
    const statusUrl = 'http://localhost:8080/survey/status';
    const enableUrl = 'http://localhost:8080/survey/enable';
    const disableUrl = 'http://localhost:8080/survey/disable';

    const statusText = '#surveyStatus';
    const radio = '#changeConfig';
    const submitButton = '#submit';

    $.get(statusUrl, (response) => {
        const isActive = response.isActive;

        if (isActive) {
            $(statusText).html('Activa').removeClass('text-danger').addClass('text-success');
            $(radio).attr('checked', true);
            $(submitButton).html('Enviar Datos').removeClass('btn-outline-danger').addClass('btn-outline-success');
        } else {
            $(statusText).html('No disponible').removeClass('text-success').addClass('text-danger');
            $(radio).attr('checked', false);
            $(submitButton)
                .html('Encuesta No Disponible')
                .addClass('btn-outline-danger')
                .removeClass('btn-outline-success')
                .attr('disabled', true);
        }
    });

    setInterval(() => {
        $.get(statusUrl, (response) => {
            const isActive = response.isActive;

            if (isActive) {
                $(statusText).html('Activa').removeClass('text-danger').addClass('text-success');
                $(radio).attr('checked', true);
                $(submitButton).html('Enviar Datos').removeClass('btn-outline-danger').addClass('btn-outline-success');
            } else {
                $(statusText).html('No disponible').removeClass('text-success').addClass('text-danger');
                $(radio).attr('checked', false);
                $(submitButton)
                    .html('Encuesta No Disponible')
                    .addClass('btn-outline-danger')
                    .removeClass('btn-outline-success')
                    .attr('disabled', true);
            }
        });
    }, 1000);

    $(radio).click(() => {
        if ($(radio).is(':checked')) {
            $.post(enableUrl, () => {
                $(statusText).html('Activa').removeClass('text-danger').addClass('text-success');
                $(radio).attr('checked', true);
            });
        } else {
            $.post(disableUrl, () => {
                $(statusText).html('No disponible').removeClass('text-success').addClass('text-danger');
                $(radio).attr('checked', false);
            });
        }
    });
};

export default surveyConfig;
