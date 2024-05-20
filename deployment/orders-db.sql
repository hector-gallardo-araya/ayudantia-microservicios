-- Conectar a la base de datos `postgres`
\c postgres;

-- Crear la nueva base de datos
CREATE DATABASE "orders-db";

-- Conectar a la nueva base de datos
\c "orders-db";
--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2 (Debian 16.2-1.pgdg120+2)
-- Dumped by pg_dump version 16.2 (Debian 16.2-1.pgdg120+2)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: client_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client_order (
    id integer NOT NULL,
    description character varying(255),
    payment_method character varying(255),
    total integer
);


ALTER TABLE public.client_order OWNER TO postgres;

--
-- Name: client_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_order_id_seq OWNER TO postgres;

--
-- Name: client_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_order_id_seq OWNED BY public.client_order.id;


--
-- Name: order_product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.order_product (
    id integer NOT NULL,
    order_id integer,
    product_id integer,
    quantity integer
);


ALTER TABLE public.order_product OWNER TO postgres;

--
-- Name: order_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.order_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.order_product_id_seq OWNER TO postgres;

--
-- Name: order_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.order_product_id_seq OWNED BY public.order_product.id;


--
-- Name: client_order id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_order ALTER COLUMN id SET DEFAULT nextval('public.client_order_id_seq'::regclass);


--
-- Name: order_product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_product ALTER COLUMN id SET DEFAULT nextval('public.order_product_id_seq'::regclass);


--
-- Data for Name: client_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client_order (id, description, payment_method, total) FROM stdin;
7	Orden realizada por el cliente hector	EFECTIVO	10000
8	Orden 2	EFECTIVO	10000
9	Orden 2	EFECTIVO	10000
\.


--
-- Data for Name: order_product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.order_product (id, order_id, product_id, quantity) FROM stdin;
19	7	1	2
20	7	2	3
21	7	3	1
22	8	1	2
23	8	2	3
24	8	3	1
25	9	1	5
26	9	2	5
27	9	3	5
\.


--
-- Name: client_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_order_id_seq', 9, true);


--
-- Name: order_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.order_product_id_seq', 27, true);


--
-- Name: client_order client_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client_order
    ADD CONSTRAINT client_order_pkey PRIMARY KEY (id);


--
-- Name: order_product order_product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.order_product
    ADD CONSTRAINT order_product_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

