-- Inserir dados na tabela Address
INSERT INTO Address (postal_code, street_address, complement, neighborhood, city, state, ibge_code, area_code)
VALUES
    ('12345-678', 'Rua das Flores, 123', 'Apto 45', 'Jardim das Rosas', 'São Paulo', 'SP', '3550308', '11'),
    ('23456-789', 'Avenida Paulista, 1000', 'Sala 202', 'Centro', 'São Paulo', 'SP', '3550308', '11'),
    ('34567-890', 'Rua da Consolação, 500', 'Cobertura', 'Consolação', 'São Paulo', 'SP', '3550308', '11'),
       ('34567-890', 'Rua da atendente, 500', 'Cobertura', 'Consolação', 'São Paulo', 'SP', '3550308', '11');

-- Inserir dados na tabela Phone
INSERT INTO Phone (description, ddd, number)
VALUES
    ('Telefone residencial', 11, '98765-4321'),
    ('Telefone celular', 11, '91234-5678'),
     ('Telefone celular', 11, '91234-5622');

-- Inserir dados na tabela Person
INSERT INTO Person (name, birthday_date, sex_type, email, password, cpf, rg, address_id, phone_id)
VALUES
    ('Dr. Alice Smith', '1980-05-15', 'FEMALE', 'alice.smith@example.com', 'password123', '12345678900', '12345678', 1, 1),
    ('John Doe', '1990-07-20', 'MALE', 'john.doe@example.com', 'password456', '23456789000', '23456789', 2, 2),
    ('Jane Roe', '1995-11-10', 'FEMALE', 'jane.roe@example.com', 'password789', '34567890100', '34567890', 3, 1),
     ('Atendente-josé', '2000-11-10', 'FEMALE', 'jose.roe@example.com', 'password789', '34567890100', '34567890', 3, 3);

-- Inserir dados na tabela Doctor
INSERT INTO Doctor (id, crm)
VALUES
    (1, 'CRM12345');

-- Inserir dados na tabela Patient
INSERT INTO Patient (id)
VALUES
    (2),
    (3);

INSERT INTO med_chart (id, symptoms, weight, height, pressure) VALUES
(1, 'Dor de cabeça e febre', 65.0, 1.70, 120.80),
(2, 'Cansaço e falta de ar', 70.0, 1.75, 130.85);

INSERT INTO Ticket (id, created_at, expire_in)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', NOW(), '2024-12-31'),
    ('e09b41a4-3f1f-4e36-946d-540c3e6f91b1', NOW(), '2024-11-30');

INSERT INTO Payment (id, payment_date, type, sub_total, discount, total)
VALUES
    ('d42b40e3-3c22-4e09-8a0c-6f55d1bfe9bb', NOW(), 'Credit Card', 100.00, 10.00, 90.00),
    ('b7c9e5f2-6d29-42d8-b3a6-8b885c9e2d0a', NOW() - INTERVAL '1 day', 'Debit Card', 50.00, 5.00, 45.00),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', NOW() - INTERVAL '2 days', 'PayPal', 75.00, 0.00, 75.00),
    ('e09b41a4-3f1f-4e36-946d-540c3e6f91b1', NOW() - INTERVAL '3 days', 'Cash', 30.00, 2.00, 28.00),
    ('e0a6c3b8-d3c5-4e5a-b1e2-b0e9c8d72e98', NOW() - INTERVAL '4 days', 'Bank Transfer', 200.00, 20.00, 180.00);

-- Inserir dados na tabela Exam
INSERT INTO Exam (name, type)
VALUES
    ('Blood Test', 'Routine'),
    ('X-Ray', 'Diagnostic');

INSERT INTO Appointment (id, date, description, patient_id, doctor_id, med_chart_id, ticket_id, payment_id)
VALUES
    (1, '2024-09-01', 'Routine checkup', 2, 1, 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'd42b40e3-3c22-4e09-8a0c-6f55d1bfe9bb'),
    (2, '2024-09-02', 'Follow-up visit', 3, 1, 2, 'e09b41a4-3f1f-4e36-946d-540c3e6f91b1', 'b7c9e5f2-6d29-42d8-b3a6-8b885c9e2d0a');

INSERT INTO Specialty (id, name) VALUES (1, 'Dermatologist'), (2, 'Dentist');