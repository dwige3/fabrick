INSERT INTO account
(account_id, accounting_date, amount, currency, description, operation_id, transaction_id, type_enumeration, type_value, value_date)
VALUES(N'14537780', '2019-04-01', -800.00, N'EUR', N'BA JOHN DOE PAYMENT INVOICE 75/2017', N'00000000273015', N'1331714087', N'GBS_TRANSACTION_TYPE', N'GBS_TRANSACTION_TYPE_0023', '2019-04-01');

INSERT INTO NF2019.dbo.account
(account_id, accounting_date, amount, currency, description, operation_id, transaction_id, type_enumeration, type_value, value_date)
VALUES(N'14537780', '2019-04-01', -1.00, N'EUR', N'CO MONEY TRANSFER FEES', N'00000000273015', N'1331714088', N'GBS_TRANSACTION_TYPE', N'GBS_TRANSACTION_TYPE_0015', '2019-04-01');


-- SET IDENTITY_INSERT NF2019.dbo.account_balance ON;
INSERT INTO NF2019.dbo.account_balance
(account_id, available_balance, balance, currency, [date])
VALUES(N'14537780', 29.64, 29.64, N'EUR', '2018-08-17');


INSERT INTO NF2019.dbo.money_transfer
(account_id, accounted_datetime, created_datetime, creditor_account_code, creditor_address, creditor_bic_code, creditor_city, creditor_country_code, creditor_name, creditor_value_date, cro, debitor_account_code, debitor_bic_code, debitor_name, debtor_value_date, description, direction, fee_accountid, fee_type, has_tax_relief, is_instant, is_urgent, money_transfer_id, status, trn, uri, amount_id)
VALUES(N'14537780', '2019-04-10 10:38:56.000', '2019-04-10 10:38:55.000', N'IT23A0336844430152923804660', N'', N'SELBIT2BXXX', N'', N'', N'John Doe', '2019-04-10', N'1234566788907', N'IT61F0326802230280596327270', N'', N'', '2019-04-10', N'Description', N'OUTGOING', N'12345678', N'SHA', 0, 0, 0, N'452516859427', N'EXECUTED', N'AJFSAD1234566788907CCSFDGTGVGV', N'REMITTANCE_INFORMATION', 1);
INSERT INTO NF2019.dbo.money_transfer
(account_id, accounted_datetime, created_datetime, creditor_account_code, creditor_address, creditor_bic_code, creditor_city, creditor_country_code, creditor_name, creditor_value_date, cro, debitor_account_code, debitor_bic_code, debitor_name, debtor_value_date, description, direction, fee_accountid, fee_type, has_tax_relief, is_instant, is_urgent, money_transfer_id, status, trn, uri, amount_id)
VALUES(N'14537781', NULL, NULL, N'IT23A0336844430152923804660', NULL, N'SELBIT2BXXX', NULL, NULL, N'John Doe', NULL, NULL, NULL, NULL, NULL, NULL, N'Payment invoice 75/2017', NULL, N'45685475', N'SHA', NULL, 0, 0, NULL, NULL, NULL, N'REMITTANCE_INFORMATION', NULL);

INSERT INTO NF2019.dbo.money_transfer_entity_fees
(money_transfer_entity_id, amount, currency, description, fee_code)
VALUES(1, 0.25, N'EUR', N'Money transfer execution fee', N'MK001');
INSERT INTO NF2019.dbo.money_transfer_entity_fees
(money_transfer_entity_id, amount, currency, description, fee_code)
VALUES(1, 3.50, N'EUR', N'Currency exchange fee', N'MK003');


