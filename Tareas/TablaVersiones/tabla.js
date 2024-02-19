const versionData = {
    "5.3.2": {
        files: ["Archivo 1", "Archivo 2", "Archivo 3"],
        details: ["Detalle 1", "Detalle 2", "Detalle 3"],
        config: ["Configuración 1", "Configuración 2", "Configuración 3"]
    },
    "4.6.2": {
        files: ["Archivo 1", "Archivo 2", "Archivo 3"],
        details: ["Detalle 1", "Detalle 2", "Detalle 3"],
        config: ["Configuración 1", "Configuración 2", "Configuración 3"]
    },
    "3.4.1": {
        files: ["Archivo 1", "Archivo 2", "Archivo 3"],
        details: ["Detalle 1", "Detalle 2", "Detalle 3"],
        config: ["Configuración 1", "Configuración 2", "Configuración 3"]
    },
    "2.3.2": {
        files: ["Archivo 1", "Archivo 2", "Archivo 3"],
        details: ["Detalle 1", "Detalle 2", "Detalle 3"],
        config: ["Configuración 1", "Configuración 2", "Configuración 3"]
    },
    "1.4.0": {
        files: ["Archivo 1", "Archivo 2", "Archivo 3"],
        details: ["Detalle 1", "Detalle 2", "Detalle 3"],
        config: ["Configuración 1", "Configuración 2", "Configuración 3"]
    },
};

function showFiles(version) {
    const filesContainer = document.getElementById('filesContainer');
    const files = versionData[version].files;
    filesContainer.innerHTML = `
        <h2>Archivos de la versión ${version}</h2>
        <ul>
            ${files.map(file => `<li><a href="#">${file}</a></li>`).join('')}
        </ul>
    `;
    filesContainer.style.display = 'block';
}

function showDetails(version) {
    const detailsContainer = document.getElementById('detailsContainer');
    const details = versionData[version].details;
    detailsContainer.innerHTML = `
        <h2>Detalles de la versión ${version}</h2>
        <ul>
            ${details.map(detail => `<li>${detail}</li>`).join('')}
        </ul>
    `;
    detailsContainer.style.display = 'block';
}

function showConfig(version) {
    const configAccordionContainer = document.getElementById('configAccordionContainer');
    const config = versionData[version].config;

    let configAccordionsHTML = '';

    config.forEach((conf, index) => {
        configAccordionsHTML += `
            <div class="accordion-item">
                <h2 class="accordion-header" id="heading${index}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${index}" aria-expanded="false" aria-controls="collapse${index}">
                        Configuración ${index + 1}
                    </button>
                </h2>
                <div id="collapse${index}" class="accordion-collapse collapse" aria-labelledby="heading${index}" data-bs-parent="#configAccordionContainer">
                    <div class="accordion-body">
                        ${conf}
                    </div>
                </div>
            </div>
        `;
    });

    configAccordionContainer.innerHTML = `
    <h2>Configuración de la versión ${version}</h2>
        <div class="accordion" id="configAccordion">
            ${configAccordionsHTML}
        </div>
    `;
    configAccordionContainer.style.display = 'block';
}
