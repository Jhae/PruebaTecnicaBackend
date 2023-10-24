DROP TABLE movimiento;
DROP TABLE cuenta;
DROP TABLE cliente;
DROP TABLE persona;
DROP TABLE tipo_cuenta;
DROP TABLE tipo_movimiento;

purge recyclebin;

CREATE TABLE "DATLIB"."TIPO_MOVIMIENTO" (	
    "ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "NOMBRE" VARCHAR2(25 BYTE) NOT NULL ENABLE, 
    CONSTRAINT "TIPO_MOVIMIENTO_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "DATLIB"."TIPO_CUENTA" 
(	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "NOMBRE" VARCHAR2(25 BYTE) NOT NULL ENABLE, 
    CONSTRAINT "TIPO_CUENTA_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "DATLIB"."PERSONA" 
(	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "NOMBRES" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
    "TELEFONO" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    "IDENTIFICACION" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    "DIRECCION" VARCHAR2(250 BYTE), 
    "GENERO" VARCHAR2(1 BYTE) NOT NULL ENABLE, 
    "EDAD" NUMBER NOT NULL ENABLE, 
    CONSTRAINT "PERSONA_PK" PRIMARY KEY ("ID")
);

CREATE TABLE "DATLIB"."CLIENTE" 
(	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "CONTRASENA" VARCHAR2(250 BYTE) NOT NULL ENABLE, 
    "ESTADO" NUMBER(1,0) DEFAULT 0 NOT NULL ENABLE, 
    "ID_PERSONA" NUMBER, 
    CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
    TABLESPACE "USERS"  ENABLE, 
    CONSTRAINT "CLIENTE_FK1" FOREIGN KEY ("ID")
    REFERENCES "DATLIB"."PERSONA" ("ID") ENABLE
);

CREATE TABLE "DATLIB"."CUENTA" 
(	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "NUMERO" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    "ESTADO" NUMBER(1,0) DEFAULT 0 NOT NULL ENABLE, 
    "SALDO_INICIAL" NUMBER(14,2) DEFAULT 0.00 NOT NULL ENABLE, 
    "ID_CLIENTE" NUMBER, 
    "ID_TIPO_CUENTA" NUMBER NOT NULL ENABLE, 
    CONSTRAINT "CUENTA_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
    TABLESPACE "USERS"  ENABLE, 
    CONSTRAINT "CUENTA_FK1" FOREIGN KEY ("ID")
    REFERENCES "DATLIB"."CLIENTE" ("ID") ENABLE, 
    CONSTRAINT "CUENTA_FK2" FOREIGN KEY ("ID")
    REFERENCES "DATLIB"."TIPO_CUENTA" ("ID") ENABLE
);

CREATE TABLE "DATLIB"."MOVIMIENTO" 
(	"ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  NOT NULL ENABLE, 
    "SALDO" NUMBER(14,2) DEFAULT 0.00 NOT NULL ENABLE, 
    "VALOR" NUMBER(14,2) NOT NULL ENABLE, 
    "FECHA" TIMESTAMP (6) DEFAULT SYSTIMESTAMP, 
    "ID_CUENTA" NUMBER NOT NULL ENABLE, 
    "ID_TIPO_MOVIMIENTO" NUMBER NOT NULL ENABLE, 
    CONSTRAINT "MOVIMIENTO_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
    TABLESPACE "USERS"  ENABLE, 
    CONSTRAINT "MOVIMIENTO_FK1" FOREIGN KEY ("ID")
    REFERENCES "DATLIB"."CUENTA" ("ID") ENABLE, 
    CONSTRAINT "MOVIMIENTO_FK2" FOREIGN KEY ("ID")
    REFERENCES "DATLIB"."TIPO_MOVIMIENTO" ("ID") ENABLE
);

