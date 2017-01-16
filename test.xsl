<?xml version='1.0' encoding='UTF-8'?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
            xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"
            xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
    <S:Header>
        <wsse:Security S:actor="http://smev.gosuslugi.ru/actors/smev">
            <ds:Signature xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                <ds:SignedInfo>
                    <ds:CanonicalizationMethod Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                    <ds:SignatureMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr34102001-gostr3411"/>
                    <ds:Reference URI="#body">
                        <ds:Transforms>
                            <ds:Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/>
                            <ds:Transform Algorithm="http://www.w3.org/2001/10/xml-exc-c14n#"/>
                        </ds:Transforms>
                        <ds:DigestMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#gostr3411"/>
                        <ds:DigestValue>Sj43WZpUnbPxRgdzinsiIYNNcEXOwGHnI3GoWQ52sAk=</ds:DigestValue>
                    </ds:Reference>
                </ds:SignedInfo>
                <ds:SignatureValue>
                    HoGRQ+sZdDlwV3796VnaXQiOVaUVUMeLGo+z1sJhVkIhqkZydbtaQraY7xhMGhN0wkj9gSVkQ0lT
                    4/UcF2H+1g==
                </ds:SignatureValue>
                <ds:KeyInfo>
                    <wsse:SecurityTokenReference>
                        <wsse:Reference URI="#FNSCertificate"/>
                    </wsse:SecurityTokenReference>
                </ds:KeyInfo>
            </ds:Signature>
            <wsse:BinarySecurityToken
                    EncodingType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary"
                    ValueType="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509v3"
                    wsu:Id="FNSCertificate">
                MIIG0zCCBoKgAwIBAgIKGweAJgAAAAABSjAIBgYqhQMCAgMwggExMRgwFgYFKoUDZAETDTEyMzQ1
                Njc4OTAxMjMxGDAWBggqhQMDgQMBARMKMTIzNDU2Nzg5MDEoMCYGA1UECQwf0KHRg9GJ0LXQstGB
                0LrQuNC5INCy0LDQuyDQtC4yNjEXMBUGCSqGSIb3DQEJARYIY2FAcnQucnUxCzAJBgNVBAYTAlJV
                MRUwEwYDVQQIDAzQnNC+0YHQutCy0LAxFTATBgNVBAcMDNCc0L7RgdC60LLQsDEkMCIGA1UECgwb
                0J7QkNCeINCg0L7RgdGC0LXQu9C10LrQvtC8MTAwLgYDVQQLDCfQo9C00L7RgdGC0L7QstC10YDR
                j9GO0YnQuNC5INGG0LXQvdGC0YAxJTAjBgNVBAMMHNCi0LXRgdGC0L7QstGL0Lkg0KPQpiDQoNCi
                0JowHhcNMTIwNzAzMTMwMjAwWhcNMTMwNzAzMTMxMTAwWjCBoTELMAkGA1UEBhMCUlUxazBpBgNV
                BAoeYgQkBDUENAQ1BEAEMAQ7BEwEPQQwBE8AIAQdBDAEOwQ+BDMEPgQyBDAETwAgBCEEOwRDBDYE
                MQQwACAEIAQ+BEEEQQQ4BDkEQQQ6BD4EOQAgBCQENQQ0BDUEQAQwBEYEOAQ4MSUwIwYDVQQDHhwE
                IQQcBBIAIAQkBB0EIQAgBCAEPgRBBEEEOAQ4MGMwHAYGKoUDAgITMBIGByqFAwICJAAGByqFAwIC
                HgEDQwAEQIAG53Gr/cXa1kfLZkaCR7A1u6VgWDqt36Gp6fqR/1TzhLwuinFjJv2WaTwKqSu52Gs8
                GJ/ZktI/AAPqWS/08hqjggQFMIIEATAOBgNVHQ8BAf8EBAMCBPAwJAYDVR0lBB0wGwYGKoUDZAIC
                BgcqhQMCAiIGBggrBgEFBQcDAjAdBgNVHQ4EFgQUG+YsQdkI8GJL0wxEy8u5KbINeiUwggFyBgNV
                HSMEggFpMIIBZYAUGqzsqJqyMEtnZuWrLCXqqwqBwdOhggE5pIIBNTCCATExGDAWBgUqhQNkARMN
                MTIzNDU2Nzg5MDEyMzEYMBYGCCqFAwOBAwEBEwoxMjM0NTY3ODkwMSgwJgYDVQQJDB/QodGD0YnQ
                tdCy0YHQutC40Lkg0LLQsNC7INC0LjI2MRcwFQYJKoZIhvcNAQkBFghjYUBydC5ydTELMAkGA1UE
                BhMCUlUxFTATBgNVBAgMDNCc0L7RgdC60LLQsDEVMBMGA1UEBwwM0JzQvtGB0LrQstCwMSQwIgYD
                VQQKDBvQntCQ0J4g0KDQvtGB0YLQtdC70LXQutC+0LwxMDAuBgNVBAsMJ9Cj0LTQvtGB0YLQvtCy
                0LXRgNGP0Y7RidC40Lkg0YbQtdC90YLRgDElMCMGA1UEAwwc0KLQtdGB0YLQvtCy0YvQuSDQo9Cm
                INCg0KLQmoIQYkxHbzgUcqZGv3DLDR40GzBZBgNVHR8EUjBQME6gTKBKhkhodHRwOi8vMTg4LjI1
                NC4xNi44OS9yYS9jZHAvMWFhY2VjYTg5YWIyMzA0YjY3NjZlNWFiMmMyNWVhYWIwYTgxYzFkMy5j
                cmwwRwYIKwYBBQUHAQEEOzA5MDcGCCsGAQUFBzAChitodHRwOi8vMTg4LjI1NC4xNi44OS9yYS9j
                ZHAvdGVzdF9jYV9ydGsuY3J0ME8GBSqFA2RvBEYMRCLQmtGA0LjQv9GC0L7Qn9GA0L4gQ1NQIiAo
                0LLQtdGA0YHQuNGPIDMuNikgKNC40YHQv9C+0LvQvdC10L3QuNC1IDEpMCsGA1UdEAQkMCKADzIw
                MTIwNzAzMTMwMjAwWoEPMjAxMzA3MDMxMzAyMDBaMCoGA1UdIAQjMCEwCAYGKoUDZAICMAkGByqF
                AwICIgYwCgYIKwYBBQUHAwIwgeUGBSqFA2RwBIHbMIHYDCsi0JrRgNC40L/RgtC+0J/RgNC+IENT
                UCIgKNCy0LXRgNGB0LjRjyAzLjYpDFQi0KPQtNC+0YHRgtC+0LLQtdGA0Y/RjtGJ0LjQuSDRhtC1
                0L3RgtGAICLQmtGA0LjQv9GC0L7Qn9GA0L4g0KPQpiIiINCy0LXRgNGB0LjRjyAxLjUMLNCh0KQv
                MTI0LTE1NDMg0L7RgiA0INC+0LrRgtGP0LHRgNGPIDIwMTAg0LMuDCXQodCkLzEyOC0xNjU4INC+
                0YIgMDEg0LzQsNGPIDIwMTEg0LMuMAgGBiqFAwICAwNBALGLhGEAPO2e9F7bpPK8xfZI4L9ljyOG
                Tc0oR62g+Rh0WZD4+3//KLLLSa1N1Ve7yy0flmLAXxQLW1JTlzfu8PI=
            </wsse:BinarySecurityToken>
        </wsse:Security>
    </S:Header>
    <S:Body wsu:Id="body">
        <ws:queryINNFLFIODRResponse xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.unisoft/"
                                    xmlns:xml="http://www.w3.org/XML/1998/namespace">
            <smev:Message xmlns:smev="http://smev.gosuslugi.ru/rev111111">
                <smev:Sender>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Sender>
                <smev:Recipient>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Recipient>
                <smev:Originator>
                    <smev:Code>FNSR01001</smev:Code>
                    <smev:Name>ФНС России</smev:Name>
                </smev:Originator>
                <smev:TypeCode>GSRV</smev:TypeCode>
                <smev:Status>ACCEPT</smev:Status>
                <smev:Date>2012-07-25T07:08:31Z</smev:Date>
                <smev:ExchangeType>2</smev:ExchangeType>
                <smev:TestMsg/>
            </smev:Message>
            <smev:MessageData xmlns:smev="http://smev.gosuslugi.ru/rev111111">
                <smev:AppData
                        xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"
                        wsu:Id="fns-AppData">
                    <Документ xmlns="http://ws.unisoft/INNFIODR/Query/Rs" ВерсФорм="4.01">
                        <ИдЗапросФ>36109</ИдЗапросФ>
                    </Документ>
                </smev:AppData>
            </smev:MessageData>
        </ws:queryINNFLFIODRResponse>
    </S:Body>
</S:Envelope>