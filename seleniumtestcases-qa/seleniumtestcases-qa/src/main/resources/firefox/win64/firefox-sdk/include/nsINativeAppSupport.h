/*
 * DO NOT EDIT.  THIS FILE IS GENERATED FROM ../../../dist/idl\nsINativeAppSupport.idl
 */

#ifndef __gen_nsINativeAppSupport_h__
#define __gen_nsINativeAppSupport_h__


#ifndef __gen_nsISupports_h__
#include "nsISupports.h"
#endif

/* For IDL files that don't want to include root IDL files. */
#ifndef NS_NO_VTABLE
#define NS_NO_VTABLE
#endif
class nsIXULWindow; /* forward declaration */

class nsICmdLineService; /* forward declaration */


/* starting interface:    nsINativeAppSupport */
#define NS_INATIVEAPPSUPPORT_IID_STR "5fdf8480-1f98-11d4-8077-00600811a9c3"

#define NS_INATIVEAPPSUPPORT_IID \
  {0x5fdf8480, 0x1f98, 0x11d4, \
    { 0x80, 0x77, 0x00, 0x60, 0x08, 0x11, 0xa9, 0xc3 }}

class NS_NO_VTABLE nsINativeAppSupport : public nsISupports {
 public:

  NS_DECLARE_STATIC_IID_ACCESSOR(NS_INATIVEAPPSUPPORT_IID)

  /* boolean start (); */
  NS_IMETHOD Start(bool *_retval) = 0;

  /* void enable (); */
  NS_IMETHOD Enable(void) = 0;

  /* boolean stop (); */
  NS_IMETHOD Stop(bool *_retval) = 0;

  /* void quit (); */
  NS_IMETHOD Quit(void) = 0;

  /* void onLastWindowClosing (); */
  NS_IMETHOD OnLastWindowClosing(void) = 0;

  /* void ReOpen (); */
  NS_IMETHOD ReOpen(void) = 0;

};

  NS_DEFINE_STATIC_IID_ACCESSOR(nsINativeAppSupport, NS_INATIVEAPPSUPPORT_IID)

/* Use this macro when declaring classes that implement this interface. */
#define NS_DECL_NSINATIVEAPPSUPPORT \
  NS_IMETHOD Start(bool *_retval) override; \
  NS_IMETHOD Enable(void) override; \
  NS_IMETHOD Stop(bool *_retval) override; \
  NS_IMETHOD Quit(void) override; \
  NS_IMETHOD OnLastWindowClosing(void) override; \
  NS_IMETHOD ReOpen(void) override; 

/* Use this macro when declaring the members of this interface when the
   class doesn't implement the interface. This is useful for forwarding. */
#define NS_DECL_NON_VIRTUAL_NSINATIVEAPPSUPPORT \
  NS_METHOD Start(bool *_retval); \
  NS_METHOD Enable(void); \
  NS_METHOD Stop(bool *_retval); \
  NS_METHOD Quit(void); \
  NS_METHOD OnLastWindowClosing(void); \
  NS_METHOD ReOpen(void); 

/* Use this macro to declare functions that forward the behavior of this interface to another object. */
#define NS_FORWARD_NSINATIVEAPPSUPPORT(_to) \
  NS_IMETHOD Start(bool *_retval) override { return _to Start(_retval); } \
  NS_IMETHOD Enable(void) override { return _to Enable(); } \
  NS_IMETHOD Stop(bool *_retval) override { return _to Stop(_retval); } \
  NS_IMETHOD Quit(void) override { return _to Quit(); } \
  NS_IMETHOD OnLastWindowClosing(void) override { return _to OnLastWindowClosing(); } \
  NS_IMETHOD ReOpen(void) override { return _to ReOpen(); } 

/* Use this macro to declare functions that forward the behavior of this interface to another object in a safe way. */
#define NS_FORWARD_SAFE_NSINATIVEAPPSUPPORT(_to) \
  NS_IMETHOD Start(bool *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Start(_retval); } \
  NS_IMETHOD Enable(void) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Enable(); } \
  NS_IMETHOD Stop(bool *_retval) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Stop(_retval); } \
  NS_IMETHOD Quit(void) override { return !_to ? NS_ERROR_NULL_POINTER : _to->Quit(); } \
  NS_IMETHOD OnLastWindowClosing(void) override { return !_to ? NS_ERROR_NULL_POINTER : _to->OnLastWindowClosing(); } \
  NS_IMETHOD ReOpen(void) override { return !_to ? NS_ERROR_NULL_POINTER : _to->ReOpen(); } 

#if 0
/* Use the code below as a template for the implementation class for this interface. */

/* Header file */
class nsNativeAppSupport : public nsINativeAppSupport
{
public:
  NS_DECL_ISUPPORTS
  NS_DECL_NSINATIVEAPPSUPPORT

  nsNativeAppSupport();

private:
  ~nsNativeAppSupport();

protected:
  /* additional members */
};

/* Implementation file */
NS_IMPL_ISUPPORTS(nsNativeAppSupport, nsINativeAppSupport)

nsNativeAppSupport::nsNativeAppSupport()
{
  /* member initializers and constructor code */
}

nsNativeAppSupport::~nsNativeAppSupport()
{
  /* destructor code */
}

/* boolean start (); */
NS_IMETHODIMP nsNativeAppSupport::Start(bool *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* void enable (); */
NS_IMETHODIMP nsNativeAppSupport::Enable()
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* boolean stop (); */
NS_IMETHODIMP nsNativeAppSupport::Stop(bool *_retval)
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* void quit (); */
NS_IMETHODIMP nsNativeAppSupport::Quit()
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* void onLastWindowClosing (); */
NS_IMETHODIMP nsNativeAppSupport::OnLastWindowClosing()
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* void ReOpen (); */
NS_IMETHODIMP nsNativeAppSupport::ReOpen()
{
    return NS_ERROR_NOT_IMPLEMENTED;
}

/* End of implementation class template. */
#endif


#endif /* __gen_nsINativeAppSupport_h__ */
