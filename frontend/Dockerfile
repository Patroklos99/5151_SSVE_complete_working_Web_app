FROM node:18.12.0-alpine

WORKDIR /app

# Faut ajouter le dossier de nos modules au $PATH
ENV PATH /app/node_modules/.bin:$PATH

COPY package.json ./
COPY package-lock.json ./

RUN npm install  --silent # --silent parce les logs c'est pour les nuls
RUN npm install react-scripts@3.4.1 -g --silent

COPY . ./

CMD ["npm", "start"]
