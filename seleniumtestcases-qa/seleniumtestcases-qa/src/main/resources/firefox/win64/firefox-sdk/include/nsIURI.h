/*
 * DO NOT EDIT.  THIS FILE IS GENERATED FROM ../../../dist/idl\nsIURI.idl
 */

#ifndef __gen_nsIURI_h__
#define __gen_nsIURI_h__


#ifndef __gen_nsISupports_h__
#include "nsISupports.h"
#endif

/* For IDL files that don't want to include root IDL files. */
#ifndef NS_NO_VTABLE
#define NS_NO_VTABLE
#endif
#undef GetPort  // XXX Windows!
#undef SetPort  // XXX Windows!

/* starting interface:    nsIURI */
#define NS_IURI_IID_STR "92073a54-6d78-4f30-913a-b871813208c6"

#define NS_IURI_IID \
  {0x92073a54, 0x6d78, 0x4f30, \
    { 0x91, 0x3a, 0xb8, 0x71, 0x81, 0x32, 0x08, 0xc6 }}

class NS_NO_VTABLE nsIURI : public nsISupports {
 public:

  NS_DECLARE_STATIC_IID_ACCESSOR(NS_IURI_IID)

  /* attribute AUTF8String spec; */
  NS_IMETHOD GetSpec(nsACString & aSpec) = 0;
  NS_IMETHOD SetSpec(const nsACString & aSpec) = 0;

  /* readonly attribute AUTF8String prePath; */
  NS_IMETHOD GetPrePath(nsACString & aPrePath) = 0;

  /* attribute ACString scheme; */
  NS_IMETHOD GetScheme(nsACString & aScheme) = 0;
  NS_IMETHOD SetScheme(const nsACString & aScheme) = 0;

  /* attribute AUTF8String userPass; */
  NS_IMETHOD GetUserPass(nsACString & aUserPass) = 0;
  NS_IMETHOD SetUserPass(const nsACString & aUserPass) = 0;

  /* attribute AUTF8String username; */
  NS_IMETHOD GetUsername(nsACString & aUsername) = 0;
  NS_IMETHOD SetUsername(const nsACString & aUsername) = 0;

  /* attribute AUTF8String password; */
  NS_IMETHOD GetPassword(nsACString & aPassword) = 0;
  NS_IMETHOD SetPassword(const nsACString & aPassword) = 0;

  /* attribute AUTF8String hostPort; */
  NS_IMETHOD GetHostPort(nsACString & aHostPort) = 0;
  NS_IMETHOD SetHostPort(const nsACString & aHostPort) = 0;

  /* attribute AUTF8String host; */
  NS_IMETHOD GetHost(nsACString & aHost) = 0;
  NS_IMETHOD SetHost(const nsACString & aHost) = 0;

  /* attribute long port; */
  NS_IMETHOD GetPort(int32_t *aPort) = 0;
  NS_IMETHOD SetPort(int32_t aPort) = 0;

  /* attribute AUTF8String path; */
  NS_IMETHOD GetPath(nsACString & aPath) = 0;
  NS_IMETHOD SetPath(const nsACString & aPath) = 0;

  /* boolean equals (in nsIURI other); */
  NS_IMETHOD Equals(nsIURI *other, bool *_retval) = 0;

  /* boolean schemeIs (in string scheme); */
  NS_IMETHOD SchemeIs(const char * scheme, bool *_retval) = 0;

  /* nsIURI clone (); */
  NS_IMETHOD Clone(nsIURI * *_retval) = 0;

  /* AUTF8String resolve (in AUTF8String relativePath); */
  NS_IMETHOD Resolve(const nsACString & relativePath, nsACString & _retval) = 0;

  /* readonly attribute ACString asciiSpec; */
  NS_IMETHOD GetAsciiSpec(nsACString & aAsciiSpec) = 0;

  /* readonly attribute ACString asciiHostPort; */
  NS_IMETHOD GetAsciiHostPort(nsACString & aAsciiHostPort) = 0;

  /* readonly attribute ACString asciiHost; */
  NS_IMETHOD GetAsciiHost(nsACString & aAsciiHost) = 0;

  /* readonly attribute ACString originCharset; */
  NS_IMETHOD GetOriginCharset(nsACString & aOriginCharset) = 0;

  /* attribute AUTF8String ref; */
  NS_IMETHOD GetRef(nsACString & aRef) = 0;
  NS_IMETHOD SetRef(const nsACString & aRef) = 0;

  /* boolean equalsExceptRef (in nsIURI other); */
  NS_IMETHOD EqualsExceptRef(nsIURI *other, bool *_retval) = 0;

  /* nsIURI cloneIgnoringRef (); */
  NS_IMETHOD CloneIgnoringRef(nsIURI * *_retval) = 0;

  /* readonly attribute AUTF8String specIgnoringRef; */
  NS_IMETHOD GetSpecIgnoringRef(nsACString & aSpecIgnoringRef) = 0;

  /* readonly attribute boolean hasRef; */
  NS_IMETHOD GetHasRef(bool *aHasRef) = 0;

};

  NS_DEFINE_STATIC_IID_ACCESSOR(nsIURI, NS_IURI_IID)

/* Use this macro when declaring classes that implement this interface. */
#define NS_DECL_NSIURI \
  NS_IMETHOD GetSpec(nsACString & aSpec) override; \
  NS_IMETHOD SetSpec(const nsACString & aSpec) override; \
  NS_IMETHOD GetPrePath(nsACString & aPrePath) override; \
  NS_IMETHOD GetScheme(nsACString & aScheme) override; \
  NS_IMETHOD SetScheme(const nsACString & aScheme) override; \
  NS_IMETHOD GetUserPass(nsACString & aUserPass) override; \
  NS_IMETHOD SetUserPass(const nsACString & aUserPass) override; \
  NS_IMETHOD GetUsername(nsACString & aUsername) override; \
  NS_IMETHOD SetUsername(const nsACString & aUsername) override; \
  NS_IMETHOD GetPassword(nsACString & aPassword) override; \
  NS_IMETHOD SetPassword(const nsACString & aPassword) override; \
  NS_IMETHOD GetHostPort(nsACString & aHostPort) override; \
  NS_IMETHOD SetHostPort(const nsACString & aHostPort) override; \
  NS_IMETHOD GetHost(nsACString & aHost) override; \
  NS_IMETHOD SetHost(const nsACString & aHost) override; \
  NS_IMETHOD GetPort(int32_t *aPort) override; \
  NS_IMETHOD SetPort(int32_t aPort) override; \
  NS_IMETHOD GetPath(nsACString & aPath) override; \
  NS_IMETHOD SetPath(const nsACString & aPath) override; \
  NS_IMETHOD Equals(nsIURI *other, bool *_retval) override; \
  NS_IMETHOD SchemeIs(const char * scheme, bool *_retval) override; \
  NS_IMETHOD Clone(nsIURI * *_retval) override; \
  NS_IMETHOD Resolve(const nsACString & relativePath, nsACString & _retval) override; \
  NS_IMETHOD GetAsciiSpec(nsACString & aAsciiSpec) override; \
  NS_IMETHOD GetAsciiHostPort(nsACString & aAsciiHostPort) override; \
  NS_IMETHOD GetAsciiHost(nsACString & aAsciiHost) override; \
  NS_IMETHOD GetOriginCharset(nsACString & aOriginCharset) override; \
  NS_IMETHOD GetRef(nsACString & aRef) override; \
  NS_IMETHOD SetRef(const nsACString & aRef) override; \
  NS_IMETHOD EqualsExceptRef(nsIURI *other, bool *_retval) override; \
  NS_IMETHOD CloneIgnoringRef(nsIURI * *_retval) override; \
  NS_IMETHOD GetSpecIgnoringRef(nsACString & aSpecIgnoringRef) override; \
  NS_IMETHOD GetHasRef(bool *aHasRef) override; 

/* Use this macro when declaring the members of this interface when the
   class doesn't implement the interface. This is useful for forwarding. */
#define NS_DECL_NON_VIRTUAL_NSIURI \
  NS_METHOD GetSpec(nsACString & aSpec); \
  NS_METHOD SetSpec(const nsACString & aSpec); \
  NS_METHOD GetPrePath(nsACString & aPrePath); \
  NS_METHOD GetScheme(nsACString & aScheme); \
  NS_METHOD SetScheme(const nsACString & aScheme); \
  NS_METHOD GetUserPass(nsACString & aUserPass); \
  NS_METHOD SetUserPass(const nsACString & aUserPass); \
  NS_METHOD GetUsername(nsACString & aUsername); \
  NS_METHOD SetUsername(const nsACString & aUsername); \
  NS_METHOD GetPassword(nsACString & aPassword); \
  NS_METHOD SetPassword(const nsACString & aPassword); \
  NS_METHOD GetHostPort(nsACString & aHostPort); \
  NS_METHOD SetHostPort(const nsACString & aHostPort); \
  NS_METHOD GetHost(nsACString & aHost); \
  NS_METHOD SetHost(const nsACString & aHost); \
  NS_METHOD GetPort(int32_t *aPort); \
  NS_METHOD SetPort(int32_t aPort); \
  NS_METHOD GetPath(nsACString & aPath); \
  NS_METHOD SetPath(const nsACString & aPath); \
  NS_METHOD Equals(nsIURI *other, bool *_retval); \
  NS_METHOD SchemeIs(const char * scheme, bool *_retval); \
  NS_METHOD Clone(nsIURI * *_retval); \
  NS_METHOD Resolve(const nsACString & relativePath, nsACString & _retval); \
  NS_METHOD GetAsciiSpec(nsACString & aAsciiSpec); \
  NS_METHOD GetAsciiHostPort(nsACString & aAsciiHostPort); \
  NS_METHOD GetAsciiHost(nsACString & aAsciiHost); \
  NS_METHOD GetOriginCharset(nsACString & aOriginCharset); \
  NS_METHOD GetRef(nsACString & aRef); \
  NS_METHOD SetRef(const nsACString & aRef); \
  NS_METHOD EqualsExceptRef(nsIURI *other, bool *_retval); \
  NS_METHOD CloneIgnoringRef(nsIURI * *_retval); \
  NS_METHOD GetSpecIgnoringRef(nsACString & aSpecIgnoringRef); \
  NS_METHOD GetHasRef(bool *aHasRef); 

/* Use this macro to declare functions that forward the behavior of this interface to another object. */
#define NS_FORWARD_NSIURI(_to) \
  NS_IMETHOD GetSpec(nsACString & aSpec) override { return _to GetSpec(aSpec); } \
  NS_IMETHOD SetSpec(const nsACString & aSpec) override { return _to SetSpec(aSpec); } \
  NS_IMETHOD GetPrePath(nsACString & aPrePath) override { return _to GetPrePath(aPrePath); } \
  NS_IMETHOD GetScheme(nsACString & aScheme) override { return _to GetScheme(aScheme); } \
  NS_IMETHOD SetScheme(const nsACString & aScheme) override { return _to SetScheme(aScheme); } \
  NS_IMETHOD GetUserPass(nsACString & aUserPass) override { return _to GetUserPass(aUserPass); } \
  NS_IMETHOD SetUserPass(const nsACString & aUserPass) override { return _to SetUserPass(aUserPass); } \
  NS_IMETHOD GetUsername(nsACString & aUsername) override { return _to GetUsername(aUsername); } \
  NS_IMETHOD SetUsername(const nsACString & aUsername) override { return _to SetUsername(aUsername); } \
  NS_IMETHOD GetPassword(nsACString & aPassword) override { return _to GetPassword(aPassword); } \
  NS_IMETHOD SetPassword(const nsACString & aPassword) override { return _to SetPassword(aPassword); } \
  NS_IMETHOD GetHostPort(nsACString & aHostPort) override { return _to GetHostPort(aHostPort); } \
  NS_IMETHOD SetHostPort(const nsACString & aHostPort) override { return _to SetHostPort(aHostPort); } \
  NS_IMETHOD GetHost(nsACString & aHost) override { return _to GetHost(aHost); } \
  NS_IMETHOD SetHost(const nsACString & aHost) override { return _to SetHost(aHost); } \
  NS_IMETHOD GetPort(int32_t *aPort) override { return _to GetPort(aPort); } \
  NS_IMETHOD SetPort(int32_t aPort) override { return _to SetPort(aPort); } \
  NS_IMETHOD GetPath(nsACString & aPath) override { return _to GetPath(aPath); } \
  NS_IMETHOD SetPath(const nsACString & aPath) override { return _to SetPath(aPath); } \
  NS_IMETHOD Equals(nsIURI *other, bool *_retval) override { return _to Equals(other, _retval); } \
  NS_IMETHOD SchemeIs(const char * scheme, bool *_retval) override { return _to SchemeIs(scheme, _retval); } \
  NS_IMETHOD Clone(nsIURI * *_retval) override { return _to Clone(_retval); } \
  NS_IMETHOD Resolve(const nsACString & relativePath, nsACString & _retval) override { return _to Resolve(relativePath, _retval); } \
  NS_IMETHOD GetAsciiSpec(nsACString & aAsciiSpec) override { return _to GetAsciiSpec(aAsciiSpec); } \
  NS_IMETHOD GetAsciiHostPort(nsACString & aAsciiHostPort) override { return _to GetAsciiHostPort(aAsciiHostPort); } \
  NS_IMETHOD GetAsciiHost(nsACString & aAsciiHost) override { return _to GetAsciiHost(aAsciiHost); } \
  NS_IMETHOD GetOriginCharset(nsACString & aOriginCharset) override { return _to GetOriginCharset(aOriginCharset); } \
  NS_IMETHOD GetRef(nsACString & aRef) override { return _to GetRef(aRef); } \
  NS_IMETHOD SetRef(const nsACString & aRef) override { return _to SetRef(aRef); } \
  NS_IMETHOD EqualsExceptRef(nsIURI *other, bool *_retval) override { return _to EqualsExceptRef(other, _retval); } \
  NS_IMETHOD CloneIgnoringRef(nsIURI * *_retval) override { return _to CloneIgnoringRef(_retval); } \
  NS_IMETHOD GetSpecIgnoringRef(nsACString & aSpecIgnoringRef) override { return _to GetSpecIgnoringRef(aSpecIgnoringRef); } \
  NS_IMETHOD GetHasRef(bool *aHasRef) override { return _to GetHasRef(aHasRef); } 

/* Use this macro to declare functions that forward the behavior of this interface to another object in a safe way. */
#define NS_FORWARD_SAFE_NSIURI(_to) \
  NS_IMETHOD GetSpec(nsACString & aSpec) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetSpec(aSpec); } \
  NS_IMETHOD SetSpec(const nsACString & aSpec) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetSpec(aSpec); } \
  NS_IMETHOD GetPrePath(nsACString & aPrePath) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetPrePath(aPrePath); } \
  NS_IMETHOD GetScheme(nsACString & aScheme) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetScheme(aScheme); } \
  NS_IMETHOD SetScheme(const nsACString & aScheme) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetScheme(aScheme); } \
  NS_IMETHOD GetUserPass(nsACString & aUserPass) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetUserPass(aUserPass); } \
  NS_IMETHOD SetUserPass(const nsACString & aUserPass) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetUserPass(aUserPass); } \
  NS_IMETHOD GetUsername(nsACString & aUsername) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetUsername(aUsername); } \
  NS_IMETHOD SetUsername(const nsACString & aUsername) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetUsername(aUsername); } \
  NS_IMETHOD GetPassword(nsACString & aPassword) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetPassword(aPassword); } \
  NS_IMETHOD SetPassword(const nsACString & aPassword) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetPassword(aPassword); } \
  NS_IMETHOD GetHostPort(nsACString & aHostPort) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetHostPort(aHostPort); } \
  NS_IMETHOD SetHostPort(const nsACString & aHostPort) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetHostPort(aHostPort); } \
  NS_IMETHOD GetHost(nsACString & aHost) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetHost(aHost); } \
  NS_IMETHOD SetHost(const nsACString & aHost) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetHost(aHost); } \
  NS_IMETHOD GetPort(int32_t *aPort) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetPort(aPort); } \
  NS_IMETHOD SetPort(int32_t aPort) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetPort(aPort); } \
  NS_IMETHOD GetPath(nsACString & aPath) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetPath(aPath); } \
  NS_IMETHOD SetPath(const nsACString & aPath) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetPath(aPath); } \
  NS_IMETHOD Equals(nsIURI *other, bool *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Equals(other, _retval); } \
  NS_IMETHOD SchemeIs(const char * scheme, bool *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SchemeIs(scheme, _retval); } \
  NS_IMETHOD Clone(nsIURI * *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Clone(_retval); } \
  NS_IMETHOD Resolve(const nsACString & relativePath, nsACString & _retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Resolve(relativePath, _retval); } \
  NS_IMETHOD GetAsciiSpec(nsACString & aAsciiSpec) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetAsciiSpec(aAsciiSpec); } \
  NS_IMETHOD GetAsciiHostPort(nsACString & aAsciiHostPort) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetAsciiHostPort(aAsciiHostPort); } \
  NS_IMETHOD GetAsciiHost(nsACString & aAsciiHost) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetAsciiHost(aAsciiHost); } \
  NS_IMETHOD GetOriginCharset(nsACString & aOriginCharset) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetOriginCharset(aOriginCharset); } \
  NS_IMETHOD GetRef(nsACString & aRef) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetRef(aRef); } \
  NS_IMETHOD SetRef(const nsACString & aRef) override { return !_to ? NS_ERROR_NULL_POINTER : _to->SetRef(aRef); } \
  NS_IMETHOD EqualsExceptRef(nsIURI *other, bool *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->EqualsExceptRef(other, _retval); } \
  NS_IMETHOD CloneIgnoringRef(nsIURI * *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->CloneIgnoringRef(_retval); } \
  NS_IMETHOD GetSpecIgnoringRef(nsACString & aSpecIgnoringRef) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetSpecIgnoringRef(aSpecIgnoringRef); } \
  NS_IMETHOD GetHasRef(bool *aHasRef) override { return !_to ? NS_ERROR_NULL_POINTER : _to->GetHasRef(aHasRef); } 

#if 0
/* Use the code below as a template for the implementation class for this interface. */

/* Header file */
class nsURI : public nsIURI
{
public:
  NS_DECL_ISUPPORTS
  NS_DECL_NSIURI

  nsURI();

private:
  ~nsURI();

protected:
  /* additional members */
};

/* Implementation file */
NS_IMPL_ISUPPORTS(nsURI, nsIURI)

nsURI::nsURI()
{
  /* member initializers and constructor code */
}

nsURI::~nsURI()
{
  /* destructor code */
}

/* attribute AUTF8String spec; */
NS_IMETHODIMP nsURI::GetSpec(nsACString & aSpec)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetSpec(const nsACString & aSpec)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute AUTF8String prePath; */
NS_IMETHODIMP nsURI::GetPrePath(nsACString & aPrePath)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute ACString scheme; */
NS_IMETHODIMP nsURI::GetScheme(nsACString & aScheme)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetScheme(const nsACString & aScheme)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String userPass; */
NS_IMETHODIMP nsURI::GetUserPass(nsACString & aUserPass)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetUserPass(const nsACString & aUserPass)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String username; */
NS_IMETHODIMP nsURI::GetUsername(nsACString & aUsername)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetUsername(const nsACString & aUsername)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String password; */
NS_IMETHODIMP nsURI::GetPassword(nsACString & aPassword)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetPassword(const nsACString & aPassword)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String hostPort; */
NS_IMETHODIMP nsURI::GetHostPort(nsACString & aHostPort)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetHostPort(const nsACString & aHostPort)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String host; */
NS_IMETHODIMP nsURI::GetHost(nsACString & aHost)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetHost(const nsACString & aHost)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute long port; */
NS_IMETHODIMP nsURI::GetPort(int32_t *aPort)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetPort(int32_t aPort)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String path; */
NS_IMETHODIMP nsURI::GetPath(nsACString & aPath)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetPath(const nsACString & aPath)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* boolean equals (in nsIURI other); */
NS_IMETHODIMP nsURI::Equals(nsIURI *other, bool *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* boolean schemeIs (in string scheme); */
NS_IMETHODIMP nsURI::SchemeIs(const char * scheme, bool *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* nsIURI clone (); */
NS_IMETHODIMP nsURI::Clone(nsIURI * *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* AUTF8String resolve (in AUTF8String relativePath); */
NS_IMETHODIMP nsURI::Resolve(const nsACString & relativePath, nsACString & _retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute ACString asciiSpec; */
NS_IMETHODIMP nsURI::GetAsciiSpec(nsACString & aAsciiSpec)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute ACString asciiHostPort; */
NS_IMETHODIMP nsURI::GetAsciiHostPort(nsACString & aAsciiHostPort)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute ACString asciiHost; */
NS_IMETHODIMP nsURI::GetAsciiHost(nsACString & aAsciiHost)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute ACString originCharset; */
NS_IMETHODIMP nsURI::GetOriginCharset(nsACString & aOriginCharset)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* attribute AUTF8String ref; */
NS_IMETHODIMP nsURI::GetRef(nsACString & aRef)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}
NS_IMETHODIMP nsURI::SetRef(const nsACString & aRef)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* boolean equalsExceptRef (in nsIURI other); */
NS_IMETHODIMP nsURI::EqualsExceptRef(nsIURI *other, bool *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* nsIURI cloneIgnoringRef (); */
NS_IMETHODIMP nsURI::CloneIgnoringRef(nsIURI * *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute AUTF8String specIgnoringRef; */
NS_IMETHODIMP nsURI::GetSpecIgnoringRef(nsACString & aSpecIgnoringRef)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* readonly attribute boolean hasRef; */
NS_IMETHODIMP nsURI::GetHasRef(bool *aHasRef)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* End of implementation class template. */
#endif


#endif /* __gen_nsIURI_h__ */
