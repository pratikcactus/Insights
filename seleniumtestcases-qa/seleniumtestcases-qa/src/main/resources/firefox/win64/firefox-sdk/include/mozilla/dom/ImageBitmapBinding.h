/* THIS FILE IS AUTOGENERATED FROM ImageBitmap.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_ImageBitmapBinding_h
#define mozilla_dom_ImageBitmapBinding_h

#include "js/RootingAPI.h"
#include "jspubtd.h"
#include "mozilla/ErrorResult.h"
#include "mozilla/dom/BindingDeclarations.h"
#include "mozilla/dom/BindingUtils.h"
#include "mozilla/dom/Nullable.h"
#include "mozilla/dom/UnionMember.h"

namespace mozilla {
namespace dom {

class Blob;
class CanvasRenderingContext2D;
class HTMLCanvasElement;
class HTMLImageElement;
class HTMLVideoElement;
class ImageBitmap;
struct ImageBitmapAtoms;
class ImageData;
struct NativePropertyHooks;
class OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap;
class ProtoAndIfaceCache;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

void
ImplCycleCollectionTraverse(nsCycleCollectionTraversalCallback& aCallback, OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap& aUnion, const char* aName, uint32_t aFlags = 0);


void
ImplCycleCollectionUnlink(OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap& aUnion);


class HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap
{
  friend class HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmapArgument;
  enum Type
  {
    eUninitialized,
    eHTMLImageElement,
    eHTMLVideoElement,
    eHTMLCanvasElement,
    eBlob,
    eImageData,
    eCanvasRenderingContext2D,
    eImageBitmap
  };

  union Value
  {
    UnionMember<NonNull<mozilla::dom::HTMLImageElement> > mHTMLImageElement;
    UnionMember<NonNull<mozilla::dom::HTMLVideoElement> > mHTMLVideoElement;
    UnionMember<NonNull<mozilla::dom::HTMLCanvasElement> > mHTMLCanvasElement;
    UnionMember<NonNull<mozilla::dom::Blob> > mBlob;
    UnionMember<NonNull<mozilla::dom::ImageData> > mImageData;
    UnionMember<NonNull<mozilla::dom::CanvasRenderingContext2D> > mCanvasRenderingContext2D;
    UnionMember<NonNull<mozilla::dom::ImageBitmap> > mImageBitmap;

  };

  Type mType;
  Value mValue;

  HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap(const HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap&) = delete;
  void operator=(const HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap) = delete;
public:
  explicit inline HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap()
    : mType(eUninitialized)
  {
  }

  inline ~HTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap()
  {
    Uninit();
  }

  inline NonNull<mozilla::dom::HTMLImageElement>&
  RawSetAsHTMLImageElement()
  {
    if (mType == eHTMLImageElement) {
      return mValue.mHTMLImageElement.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eHTMLImageElement;
    return mValue.mHTMLImageElement.SetValue();
  }

  inline NonNull<mozilla::dom::HTMLImageElement>&
  SetAsHTMLImageElement()
  {
    if (mType == eHTMLImageElement) {
      return mValue.mHTMLImageElement.Value();
    }
    Uninit();
    mType = eHTMLImageElement;
    return mValue.mHTMLImageElement.SetValue();
  }

  inline bool
  IsHTMLImageElement() const
  {
    return mType == eHTMLImageElement;
  }

  inline NonNull<mozilla::dom::HTMLImageElement>&
  GetAsHTMLImageElement()
  {
    MOZ_ASSERT(IsHTMLImageElement(), "Wrong type!");
    return mValue.mHTMLImageElement.Value();
  }

  inline mozilla::dom::HTMLImageElement&
  GetAsHTMLImageElement() const
  {
    MOZ_ASSERT(IsHTMLImageElement(), "Wrong type!");
    return mValue.mHTMLImageElement.Value();
  }

  inline NonNull<mozilla::dom::HTMLVideoElement>&
  RawSetAsHTMLVideoElement()
  {
    if (mType == eHTMLVideoElement) {
      return mValue.mHTMLVideoElement.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eHTMLVideoElement;
    return mValue.mHTMLVideoElement.SetValue();
  }

  inline NonNull<mozilla::dom::HTMLVideoElement>&
  SetAsHTMLVideoElement()
  {
    if (mType == eHTMLVideoElement) {
      return mValue.mHTMLVideoElement.Value();
    }
    Uninit();
    mType = eHTMLVideoElement;
    return mValue.mHTMLVideoElement.SetValue();
  }

  inline bool
  IsHTMLVideoElement() const
  {
    return mType == eHTMLVideoElement;
  }

  inline NonNull<mozilla::dom::HTMLVideoElement>&
  GetAsHTMLVideoElement()
  {
    MOZ_ASSERT(IsHTMLVideoElement(), "Wrong type!");
    return mValue.mHTMLVideoElement.Value();
  }

  inline mozilla::dom::HTMLVideoElement&
  GetAsHTMLVideoElement() const
  {
    MOZ_ASSERT(IsHTMLVideoElement(), "Wrong type!");
    return mValue.mHTMLVideoElement.Value();
  }

  inline NonNull<mozilla::dom::HTMLCanvasElement>&
  RawSetAsHTMLCanvasElement()
  {
    if (mType == eHTMLCanvasElement) {
      return mValue.mHTMLCanvasElement.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eHTMLCanvasElement;
    return mValue.mHTMLCanvasElement.SetValue();
  }

  inline NonNull<mozilla::dom::HTMLCanvasElement>&
  SetAsHTMLCanvasElement()
  {
    if (mType == eHTMLCanvasElement) {
      return mValue.mHTMLCanvasElement.Value();
    }
    Uninit();
    mType = eHTMLCanvasElement;
    return mValue.mHTMLCanvasElement.SetValue();
  }

  inline bool
  IsHTMLCanvasElement() const
  {
    return mType == eHTMLCanvasElement;
  }

  inline NonNull<mozilla::dom::HTMLCanvasElement>&
  GetAsHTMLCanvasElement()
  {
    MOZ_ASSERT(IsHTMLCanvasElement(), "Wrong type!");
    return mValue.mHTMLCanvasElement.Value();
  }

  inline mozilla::dom::HTMLCanvasElement&
  GetAsHTMLCanvasElement() const
  {
    MOZ_ASSERT(IsHTMLCanvasElement(), "Wrong type!");
    return mValue.mHTMLCanvasElement.Value();
  }

  inline NonNull<mozilla::dom::Blob>&
  RawSetAsBlob()
  {
    if (mType == eBlob) {
      return mValue.mBlob.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eBlob;
    return mValue.mBlob.SetValue();
  }

  inline NonNull<mozilla::dom::Blob>&
  SetAsBlob()
  {
    if (mType == eBlob) {
      return mValue.mBlob.Value();
    }
    Uninit();
    mType = eBlob;
    return mValue.mBlob.SetValue();
  }

  inline bool
  IsBlob() const
  {
    return mType == eBlob;
  }

  inline NonNull<mozilla::dom::Blob>&
  GetAsBlob()
  {
    MOZ_ASSERT(IsBlob(), "Wrong type!");
    return mValue.mBlob.Value();
  }

  inline mozilla::dom::Blob&
  GetAsBlob() const
  {
    MOZ_ASSERT(IsBlob(), "Wrong type!");
    return mValue.mBlob.Value();
  }

  inline NonNull<mozilla::dom::ImageData>&
  RawSetAsImageData()
  {
    if (mType == eImageData) {
      return mValue.mImageData.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eImageData;
    return mValue.mImageData.SetValue();
  }

  inline NonNull<mozilla::dom::ImageData>&
  SetAsImageData()
  {
    if (mType == eImageData) {
      return mValue.mImageData.Value();
    }
    Uninit();
    mType = eImageData;
    return mValue.mImageData.SetValue();
  }

  inline bool
  IsImageData() const
  {
    return mType == eImageData;
  }

  inline NonNull<mozilla::dom::ImageData>&
  GetAsImageData()
  {
    MOZ_ASSERT(IsImageData(), "Wrong type!");
    return mValue.mImageData.Value();
  }

  inline mozilla::dom::ImageData&
  GetAsImageData() const
  {
    MOZ_ASSERT(IsImageData(), "Wrong type!");
    return mValue.mImageData.Value();
  }

  inline NonNull<mozilla::dom::CanvasRenderingContext2D>&
  RawSetAsCanvasRenderingContext2D()
  {
    if (mType == eCanvasRenderingContext2D) {
      return mValue.mCanvasRenderingContext2D.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eCanvasRenderingContext2D;
    return mValue.mCanvasRenderingContext2D.SetValue();
  }

  inline NonNull<mozilla::dom::CanvasRenderingContext2D>&
  SetAsCanvasRenderingContext2D()
  {
    if (mType == eCanvasRenderingContext2D) {
      return mValue.mCanvasRenderingContext2D.Value();
    }
    Uninit();
    mType = eCanvasRenderingContext2D;
    return mValue.mCanvasRenderingContext2D.SetValue();
  }

  inline bool
  IsCanvasRenderingContext2D() const
  {
    return mType == eCanvasRenderingContext2D;
  }

  inline NonNull<mozilla::dom::CanvasRenderingContext2D>&
  GetAsCanvasRenderingContext2D()
  {
    MOZ_ASSERT(IsCanvasRenderingContext2D(), "Wrong type!");
    return mValue.mCanvasRenderingContext2D.Value();
  }

  inline mozilla::dom::CanvasRenderingContext2D&
  GetAsCanvasRenderingContext2D() const
  {
    MOZ_ASSERT(IsCanvasRenderingContext2D(), "Wrong type!");
    return mValue.mCanvasRenderingContext2D.Value();
  }

  inline NonNull<mozilla::dom::ImageBitmap>&
  RawSetAsImageBitmap()
  {
    if (mType == eImageBitmap) {
      return mValue.mImageBitmap.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eImageBitmap;
    return mValue.mImageBitmap.SetValue();
  }

  inline NonNull<mozilla::dom::ImageBitmap>&
  SetAsImageBitmap()
  {
    if (mType == eImageBitmap) {
      return mValue.mImageBitmap.Value();
    }
    Uninit();
    mType = eImageBitmap;
    return mValue.mImageBitmap.SetValue();
  }

  inline bool
  IsImageBitmap() const
  {
    return mType == eImageBitmap;
  }

  inline NonNull<mozilla::dom::ImageBitmap>&
  GetAsImageBitmap()
  {
    MOZ_ASSERT(IsImageBitmap(), "Wrong type!");
    return mValue.mImageBitmap.Value();
  }

  inline mozilla::dom::ImageBitmap&
  GetAsImageBitmap() const
  {
    MOZ_ASSERT(IsImageBitmap(), "Wrong type!");
    return mValue.mImageBitmap.Value();
  }

  inline void
  Uninit()
  {
    switch (mType) {
      case eUninitialized: {
        break;
      }
      case eHTMLImageElement: {
        DestroyHTMLImageElement();
        break;
      }
      case eHTMLVideoElement: {
        DestroyHTMLVideoElement();
        break;
      }
      case eHTMLCanvasElement: {
        DestroyHTMLCanvasElement();
        break;
      }
      case eBlob: {
        DestroyBlob();
        break;
      }
      case eImageData: {
        DestroyImageData();
        break;
      }
      case eCanvasRenderingContext2D: {
        DestroyCanvasRenderingContext2D();
        break;
      }
      case eImageBitmap: {
        DestroyImageBitmap();
        break;
      }
    }
  }

  bool
  ToJSVal(JSContext* cx, JS::Handle<JSObject*> scopeObj, JS::MutableHandle<JS::Value> rval) const;

private:
  inline void
  DestroyHTMLImageElement()
  {
    MOZ_ASSERT(IsHTMLImageElement(), "Wrong type!");
    mValue.mHTMLImageElement.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyHTMLVideoElement()
  {
    MOZ_ASSERT(IsHTMLVideoElement(), "Wrong type!");
    mValue.mHTMLVideoElement.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyHTMLCanvasElement()
  {
    MOZ_ASSERT(IsHTMLCanvasElement(), "Wrong type!");
    mValue.mHTMLCanvasElement.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyBlob()
  {
    MOZ_ASSERT(IsBlob(), "Wrong type!");
    mValue.mBlob.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyImageData()
  {
    MOZ_ASSERT(IsImageData(), "Wrong type!");
    mValue.mImageData.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyCanvasRenderingContext2D()
  {
    MOZ_ASSERT(IsCanvasRenderingContext2D(), "Wrong type!");
    mValue.mCanvasRenderingContext2D.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyImageBitmap()
  {
    MOZ_ASSERT(IsImageBitmap(), "Wrong type!");
    mValue.mImageBitmap.Destroy();
    mType = eUninitialized;
  }
};


class OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap : public AllOwningUnionBase
{
  friend void ImplCycleCollectionUnlink(OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap& aUnion);
  enum Type
  {
    eUninitialized,
    eHTMLImageElement,
    eHTMLVideoElement,
    eHTMLCanvasElement,
    eBlob,
    eImageData,
    eCanvasRenderingContext2D,
    eImageBitmap
  };

  union Value
  {
    UnionMember<OwningNonNull<mozilla::dom::HTMLImageElement> > mHTMLImageElement;
    UnionMember<OwningNonNull<mozilla::dom::HTMLVideoElement> > mHTMLVideoElement;
    UnionMember<OwningNonNull<mozilla::dom::HTMLCanvasElement> > mHTMLCanvasElement;
    UnionMember<OwningNonNull<mozilla::dom::Blob> > mBlob;
    UnionMember<OwningNonNull<mozilla::dom::ImageData> > mImageData;
    UnionMember<OwningNonNull<mozilla::dom::CanvasRenderingContext2D> > mCanvasRenderingContext2D;
    UnionMember<OwningNonNull<mozilla::dom::ImageBitmap> > mImageBitmap;

  };

  Type mType;
  Value mValue;

public:
  explicit inline OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap()
    : mType(eUninitialized)
  {
  }

  explicit inline OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap(const OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap& aOther)
    : mType(eUninitialized)
  {
    *this = aOther;
  }

  inline ~OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap()
  {
    Uninit();
  }

  OwningNonNull<mozilla::dom::HTMLImageElement>&
  RawSetAsHTMLImageElement();

  OwningNonNull<mozilla::dom::HTMLImageElement>&
  SetAsHTMLImageElement();

  bool
  TrySetToHTMLImageElement(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsHTMLImageElement() const
  {
    return mType == eHTMLImageElement;
  }

  inline OwningNonNull<mozilla::dom::HTMLImageElement>&
  GetAsHTMLImageElement()
  {
    MOZ_ASSERT(IsHTMLImageElement(), "Wrong type!");
    return mValue.mHTMLImageElement.Value();
  }

  inline OwningNonNull<mozilla::dom::HTMLImageElement> const &
  GetAsHTMLImageElement() const
  {
    MOZ_ASSERT(IsHTMLImageElement(), "Wrong type!");
    return mValue.mHTMLImageElement.Value();
  }

  OwningNonNull<mozilla::dom::HTMLVideoElement>&
  RawSetAsHTMLVideoElement();

  OwningNonNull<mozilla::dom::HTMLVideoElement>&
  SetAsHTMLVideoElement();

  bool
  TrySetToHTMLVideoElement(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsHTMLVideoElement() const
  {
    return mType == eHTMLVideoElement;
  }

  inline OwningNonNull<mozilla::dom::HTMLVideoElement>&
  GetAsHTMLVideoElement()
  {
    MOZ_ASSERT(IsHTMLVideoElement(), "Wrong type!");
    return mValue.mHTMLVideoElement.Value();
  }

  inline OwningNonNull<mozilla::dom::HTMLVideoElement> const &
  GetAsHTMLVideoElement() const
  {
    MOZ_ASSERT(IsHTMLVideoElement(), "Wrong type!");
    return mValue.mHTMLVideoElement.Value();
  }

  OwningNonNull<mozilla::dom::HTMLCanvasElement>&
  RawSetAsHTMLCanvasElement();

  OwningNonNull<mozilla::dom::HTMLCanvasElement>&
  SetAsHTMLCanvasElement();

  bool
  TrySetToHTMLCanvasElement(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsHTMLCanvasElement() const
  {
    return mType == eHTMLCanvasElement;
  }

  inline OwningNonNull<mozilla::dom::HTMLCanvasElement>&
  GetAsHTMLCanvasElement()
  {
    MOZ_ASSERT(IsHTMLCanvasElement(), "Wrong type!");
    return mValue.mHTMLCanvasElement.Value();
  }

  inline OwningNonNull<mozilla::dom::HTMLCanvasElement> const &
  GetAsHTMLCanvasElement() const
  {
    MOZ_ASSERT(IsHTMLCanvasElement(), "Wrong type!");
    return mValue.mHTMLCanvasElement.Value();
  }

  OwningNonNull<mozilla::dom::Blob>&
  RawSetAsBlob();

  OwningNonNull<mozilla::dom::Blob>&
  SetAsBlob();

  bool
  TrySetToBlob(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsBlob() const
  {
    return mType == eBlob;
  }

  inline OwningNonNull<mozilla::dom::Blob>&
  GetAsBlob()
  {
    MOZ_ASSERT(IsBlob(), "Wrong type!");
    return mValue.mBlob.Value();
  }

  inline OwningNonNull<mozilla::dom::Blob> const &
  GetAsBlob() const
  {
    MOZ_ASSERT(IsBlob(), "Wrong type!");
    return mValue.mBlob.Value();
  }

  OwningNonNull<mozilla::dom::ImageData>&
  RawSetAsImageData();

  OwningNonNull<mozilla::dom::ImageData>&
  SetAsImageData();

  bool
  TrySetToImageData(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsImageData() const
  {
    return mType == eImageData;
  }

  inline OwningNonNull<mozilla::dom::ImageData>&
  GetAsImageData()
  {
    MOZ_ASSERT(IsImageData(), "Wrong type!");
    return mValue.mImageData.Value();
  }

  inline OwningNonNull<mozilla::dom::ImageData> const &
  GetAsImageData() const
  {
    MOZ_ASSERT(IsImageData(), "Wrong type!");
    return mValue.mImageData.Value();
  }

  OwningNonNull<mozilla::dom::CanvasRenderingContext2D>&
  RawSetAsCanvasRenderingContext2D();

  OwningNonNull<mozilla::dom::CanvasRenderingContext2D>&
  SetAsCanvasRenderingContext2D();

  bool
  TrySetToCanvasRenderingContext2D(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsCanvasRenderingContext2D() const
  {
    return mType == eCanvasRenderingContext2D;
  }

  inline OwningNonNull<mozilla::dom::CanvasRenderingContext2D>&
  GetAsCanvasRenderingContext2D()
  {
    MOZ_ASSERT(IsCanvasRenderingContext2D(), "Wrong type!");
    return mValue.mCanvasRenderingContext2D.Value();
  }

  inline OwningNonNull<mozilla::dom::CanvasRenderingContext2D> const &
  GetAsCanvasRenderingContext2D() const
  {
    MOZ_ASSERT(IsCanvasRenderingContext2D(), "Wrong type!");
    return mValue.mCanvasRenderingContext2D.Value();
  }

  OwningNonNull<mozilla::dom::ImageBitmap>&
  RawSetAsImageBitmap();

  OwningNonNull<mozilla::dom::ImageBitmap>&
  SetAsImageBitmap();

  bool
  TrySetToImageBitmap(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsImageBitmap() const
  {
    return mType == eImageBitmap;
  }

  inline OwningNonNull<mozilla::dom::ImageBitmap>&
  GetAsImageBitmap()
  {
    MOZ_ASSERT(IsImageBitmap(), "Wrong type!");
    return mValue.mImageBitmap.Value();
  }

  inline OwningNonNull<mozilla::dom::ImageBitmap> const &
  GetAsImageBitmap() const
  {
    MOZ_ASSERT(IsImageBitmap(), "Wrong type!");
    return mValue.mImageBitmap.Value();
  }

  void
  Uninit();

  bool
  ToJSVal(JSContext* cx, JS::Handle<JSObject*> scopeObj, JS::MutableHandle<JS::Value> rval) const;

  void
  TraceUnion(JSTracer* trc);

  void
  operator=(const OwningHTMLImageElementOrHTMLVideoElementOrHTMLCanvasElementOrBlobOrImageDataOrCanvasRenderingContext2DOrImageBitmap& aOther);

private:
  void
  DestroyHTMLImageElement();

  void
  DestroyHTMLVideoElement();

  void
  DestroyHTMLCanvasElement();

  void
  DestroyBlob();

  void
  DestroyImageData();

  void
  DestroyCanvasRenderingContext2D();

  void
  DestroyImageBitmap();
};


namespace ImageBitmapBinding {

  typedef mozilla::dom::ImageBitmap NativeType;

  // We declare this as an array so that retrieving a pointer to this
  // binding's property hooks only requires compile/link-time resolvable
  // address arithmetic.  Declaring it as a pointer instead would require
  // doing a run-time load to fetch a pointer to this binding's property
  // hooks.  And then structures which embedded a pointer to this structure
  // would require a run-time load for proper initialization, which would
  // then induce static constructors.  Lots of static constructors.
  extern const NativePropertyHooks sNativePropertyHooks[];

  JSObject*
  DefineDOMInterface(JSContext* aCx, JS::Handle<JSObject*> aGlobal, JS::Handle<jsid> id, bool aDefineOnGlobal);

  const JSClass*
  GetJSClass();

  bool
  Wrap(JSContext* aCx, mozilla::dom::ImageBitmap* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

  template <class T>
  inline JSObject* Wrap(JSContext* aCx, T* aObject, JS::Handle<JSObject*> aGivenProto)
  {
    JS::Rooted<JSObject*> reflector(aCx);
    return Wrap(aCx, aObject, aObject, aGivenProto, &reflector) ? reflector.get() : nullptr;
  }

  void
  CreateInterfaceObjects(JSContext* aCx, JS::Handle<JSObject*> aGlobal, ProtoAndIfaceCache& aProtoAndIfaceCache, bool aDefineOnGlobal);

  JS::Handle<JSObject*>
  GetProtoObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

  JS::Handle<JSObject*>
  GetConstructorObjectHandle(JSContext* aCx, JS::Handle<JSObject*> aGlobal, bool aDefineOnGlobal = true);

  JSObject*
  GetConstructorObject(JSContext* aCx, JS::Handle<JSObject*> aGlobal);

} // namespace ImageBitmapBinding



} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_ImageBitmapBinding_h
