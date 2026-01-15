# Todo API – Spring Boot (MVP)

Ce projet est une API REST simple de gestion de tâches (Todo), développée avec Spring Boot.

---

## 🏗️ Architecture du projet

### 📦 Entity

- Représente le **modèle de données persisté en base**
- Ne doit pas être exposée directement à l’API

---

### 📦 DTO (Data Transfer Object)

- Représente les données **échangées via l’API**
- Permet de découpler l’API du modèle de persistance
- Évite d’exposer directement les entités JPA

---

### 📦 Mapper

- Assure la transformation entre **Entity ↔ DTO**
- Centralise la logique de mapping
- Évite la duplication de code et améliore la lisibilité

---

### 📦 Repository

- Couche d’accès aux données
- Basée sur Spring Data JPA
- Contient uniquement des opérations liées à la persistance

---

### 📦 Service

- Contient la **logique métier**
- Fait le lien entre le repository et le controller
- Utilise les mappers pour retourner des DTO

---

### 📦 Controller

- Expose les **endpoints REST**

---

## 🔐 Sécurité – Authentification JWT (kata minimal)

L’application implémente une authentification stateless basée sur JWT (JSON Web Token) afin de sécuriser les endpoints.

L’implémentation est volontairement minimaliste, dans le cadre d’un kata technique.

### JwtUtils

Crée et valide les tokens JWT.

### JwtFilter

Récupère le JWT dans la requête et authentifie l’utilisateur.

### SecurityConfig

Configure la sécurité et active l’authentification JWT.

## 🚀 Fonctionnalités (MVP)

- Créer un todo
- Récupérer tous les todos
- Récupérer un todo par ID
- Mettre à jour un todo
- Supprimer un todo

---

## 🛠️ Technologies utilisées

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 📌 Notes

- La gestion des erreurs (404, exceptions métier) a été volontairement simplifiée pour le MVP.
- Une authentification JWT pourra être ajoutée dans une version ultérieure.
