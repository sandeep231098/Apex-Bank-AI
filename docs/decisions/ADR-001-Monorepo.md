# ADR-001: Monorepo Architecture

## Status

Accepted

## Context

Apex Bank AI consists of multiple applications:

- Customer Portal
- Admin Portal
- Backend Microservices
- Infrastructure
- Documentation

Managing them in a single repository simplifies development, shared documentation, CI/CD, and versioning.

## Decision

Use a monorepo with separate applications under the `apps/` directory and backend services under the `backend/` directory.

## Consequences

- Easier onboarding
- Shared documentation
- Unified CI/CD
- Better project organization