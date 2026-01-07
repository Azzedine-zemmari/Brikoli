# Brikoli - Smart Mission Marketplace

## Présentation
Brikoli est une plateforme digitale marocaine qui met en relation des clients avec des professionnels qualifiés pour des missions courtes ou urgentes.  
Contrairement aux marketplaces freelances traditionnelles, Brikoli se concentre sur des missions rapides et basées sur des tâches spécifiques : plomberie, réparation électrique, design graphique, assistance informatique, et autres missions pouvant être réalisées en quelques heures ou jours.  
La plateforme permet aux diplômés professionnels (par exemple, étudiants de l’OFPPT) et à d’autres travailleurs qualifiés de trouver facilement des missions rémunérées, tandis que les clients bénéficient d’une aide rapide et fiable.

## Vision
Simplifier la mise en relation pour des missions de courte durée au Maroc, permettant à toute personne de trouver rapidement des professionnels de confiance tout en aidant les travailleurs qualifiés à générer des revenus efficacement.

## Utilisateurs Cibles
- **Clients** : particuliers ou petites entreprises ayant besoin de services de courte durée.  
- **Professionnels** : travailleurs indépendants qualifiés et diplômés de l’OFPPT cherchant expérience et revenus.

## MVP (Produit Minimum Viable)

### Objectif
Valider que les clients publieront des missions et que les professionnels postuleront pour les réaliser.  
Le MVP privilégie la simplicité, l’ergonomie et la confiance.

### Fonctionnalités principales
- **Authentification** : S’inscrire en tant que Client ou Professionnel, données de base (nom, email, téléphone, mot de passe), option badge “Diplômé”.  
- **Création de mission (Client)** : titre, description, catégorie, budget, localisation, urgence.  
- **Fil des missions (Professionnel)** : parcourir missions actives, filtres, postuler à une mission.  
- **Système de candidature** : acceptation/refus par le client.  
- **Messagerie** : chat privé après acceptation.  
- **Statut des missions** : Publiée → En cours → Terminée.  
- **Évaluations et avis** : note du professionnel, profil avec missions totales et moyenne.  
- **Panneau d’administration** : gestion utilisateurs, missions, candidatures.  
- **Système de paiement (Phase 2)** : séquestre, fonds libérés après mission terminée, multiples moyens de paiement.

## Stack technologique

### Backend — Spring Boot
| Couche | Technologie | Description |
|--------|------------|-------------|
| Framework principal | Spring Boot 3+ | Backend principal, mise en place simple |
| Web | Spring MVC | REST API, routage et contrôleurs propres |
| Accès aux données | Spring Data JPA / Hibernate | ORM, CRUD facile |
| Base de données | PostgreSQL | Relationnelle principale, scalable |
| Authentification | Spring Security + JWT | Token sécurisé |
| Validation | Hibernate Validator | Prévention données invalides |
| Emails / Notifications | Spring Mail / Twilio | Envoi notifications |
| Chat / Notifications | Spring WebSocket | Live chat |
| Planification | Spring Scheduler | Expiration automatique |
| Observabilité | Spring Boot Actuator | Monitoring |
| Conteneurisation | Docker | Déploiement cross-platform |

### Base de données
- **PostgreSQL** : principale  
- **MongoDB (optionnel)** : messages de chat  
- **Liquibase** : migrations de DB

### Frontend — Angular
| Couche | Technologie | Objectif |
|--------|------------|----------|
| Framework | Angular 18+ | SPA |
| UI | Angular Material / PrimeNG | Composants UI |
| Gestion d’état | NgRx | Flux de données prévisible |
| Styles | Tailwind | Styling moderne |
| Navigation | Angular Router | Navigation basée sur rôle |
| API | HttpClient + Interceptors | Communication sécurisée |
| Temps réel | RxJS + WebSocket | Chat en direct |
| Formulaires | Reactive Forms | Validation robuste |
| Tests | Jasmine / Karma / Cypress | Tests UI |
| Déploiement | Vercel / Netlify / Firebase | Hébergement global |

### DevOps & Infrastructure
- **Build** : Maven / Gradle  
- **Contrôle de version** : Git + GitHub  
- **CI/CD** : GitHub Actions  
- **Conteneurisation** : Docker Compose  
- **Monitoring** : Prometheus + Grafana (optionnel)  
- **Hébergement** : Railway / Render / AWS EC2  
- **Hébergement DB** : Supabase / ElephantSQL  

### Sécurité
- JWT, rôles CLIENT / PROFESSIONAL / ADMIN  
- Mots de passe BCrypt  
- CORS configuré  
- HTTPS obligatoire en production  

## Flux produit
1. Le client publie une mission  
2. Les professionnels parcourent et postulent  
3. Le client sélectionne un professionnel  
4. Chat pour communication  
5. Mission terminée → notation  

## Business Model
- Commission sur la valeur de la mission (2–5%)  
- Profils premium pour professionnels  
- Partenariats publicitaires  

## Roadmap future
| Phase | Focus | Fonctionnalités |
|-------|-------|----------------|
| MVP | Flux mission principal | Publication, postulation, chat, évaluations |
| Beta | Monétisation | Séquestre, vérification, analytics |
| Plateforme complète | Mobile | App mobile, partenariats |

## Design & UI
- Écrans : Landing Page, Créer Mission, Fil des Missions, Détail Mission, Dashboards Client/Pro, Chat, Évaluation  

## Indicateurs de succès MVP
- ≥ 20 missions publiées / semaine  
- ≥ 50 professionnels actifs  
- ≥ 5 missions complétées / semaine  
- Feedback utilisateur positif  

## Impact social
- Opportunités pour diplômés  
- Soutien aux freelances  
- Digitalisation du marché informel  

## Étude de marché et risques
- Opportunités : forte pénétration internet, professionnels qualifiés, besoins courts  
- Risques : confiance, qualité, régulations, paiements  
- Solutions : évaluations, badges, séquestre, support CMI/Wafacash, HTTPS, JWT  

## Expériences de validation
- Pilote OFPPT, Ads Facebook/WhatsApp, cash vs prépayé, interviews utilisateurs  

## Sources
DataReportal, Reuters, Fairwork Morocco, Market Research Future, Barlamantoday, MWN  

## Contributeurs
- **Propriétaire** : Azzedine Zemmari  
- **Contact** : azzedinezemmari@gmail.com  
- **Site web** : www.brikoli.* (bientôt disponible)
