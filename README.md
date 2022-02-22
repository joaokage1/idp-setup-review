# QR IDP 2 - Ação 2
## Criar aplicações para aplicar teorias aprendidas do material e exemplos do site do Spring 
### **Microserviços**

Esta é uma pequena aplicação, com propósitos de demonstrar os conhecimentos adiquiridos relacionados a microserviços e suas ferramentas.
O conteúdo aprendido servirá de extrema importância para o andamento das atividades ligadas ao cliente no qual me encontro alocado.

### **Seção 1 - Eureka Server**

O Netflix Eureka é um módulo do Netflix OSS, o qual permite com que serviços sejam registrados através do 
Eureka Server e descobertos através do Eureka Client, facilitando esse controle de aplicação distribuída.

Com o Eureka server o problema da pouca flexibilidade em comunicações entre serviços escalonados horizontalmente
é facilmente resolvido. O Eureka server ajuda no mapeamento e monitoramento de instâncias de uma aplicação.

### **Seção 2 - API Gateway**

Um gateway de API faz parte do sistema de gerenciamento da API. Ele intercepta todas as solicitações de entrada e as 
envia por meio desse sistema, que processa diversas funções necessárias.

Um gateway de API separa APIs públicas externas das APIs de microsserviço interno, permitindo que os microsserviços 
sejam adicionados e os limites alterados. O resultado é a capacidade de refatorar e dimensionar eles corretamente ao 
longo do tempo, sem afetar negativamente os clientes externos. 

### **Seção 3 - Open Feign**

O OpenFeign é um dos projetos do spring cloud, com foco em facilitar a comunicação entre serviços REST, substituindo
assim de vez o tão usado RestTemplate. Possui grande interação com os outros projetos spring cloud, e já possui
uma configuração padrão, que combinada com Eureka server, pode ser de grande benefício o uso de sua funcionalidade,
já com o loadBalancer padrão configurado.

## **EXTRAS**

### **DOCKER - MONGO DB**
>docker run --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=joao -e MONGO_INITDB_ROOT_PASSWORD=pass mongo

### **Scheduling Tasks**
Apenas para demonstração, foi utilizado um método agendado, com a utiliação tambmém de um lock, pois uma
vez que estamos trabalhando com sistemas sistribuídos e que podem estar rodando em mais de uma instância,
devemos nos procupar com esse método rodando apenas uma vez ao mesmo tempo.

Ref:https://github.com/lukas-krecan/ShedLock#mongo