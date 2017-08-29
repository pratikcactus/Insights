/* THIS FILE IS AUTOGENERATED FROM VTTCue.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_VTTCueBinding_h
#define mozilla_dom_VTTCueBinding_h

#include "js/RootingAPI.h"
#include "jspubtd.h"
#include "mozilla/ErrorResult.h"
#include "mozilla/dom/BindingDeclarations.h"
#include "mozilla/dom/BindingUtils.h"
#include "mozilla/dom/Nullable.h"
#include "mozilla/dom/UnionMember.h"

namespace mozilla {
namespace dom {

struct NativePropertyHooks;
class ProtoAndIfaceCache;
class TextTrackCue;
struct TextTrackCueAtoms;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

enum class AutoKeyword : uint32_t {
  Auto,
  EndGuard_
};

namespace AutoKeywordValues {
extern const EnumEntry strings[2];
} // namespace AutoKeywordValues

bool
ToJSValue(JSContext* aCx, AutoKeyword aArgument, JS::MutableHandle<JS::Value> aValue);


enum class AlignSetting : uint32_t {
  Start,
  Middle,
  End,
  Left,
  Right,
  EndGuard_
};

namespace AlignSettingValues {
extern const EnumEntry strings[6];
} // namespace AlignSettingValues

bool
ToJSValue(JSContext* aCx, AlignSetting aArgument, JS::MutableHandle<JS::Value> aValue);


enum class DirectionSetting : uint32_t {
  _empty,
  Rl,
  Lr,
  EndGuard_
};

namespace DirectionSettingValues {
extern const EnumEntry strings[4];
} // namespace DirectionSettingValues

bool
ToJSValue(JSContext* aCx, DirectionSetting aArgument, JS::MutableHandle<JS::Value> aValue);


class LongOrAutoKeyword
{
  friend class LongOrAutoKeywordArgument;
  enum Type
  {
    eUninitialized,
    eLong,
    eAutoKeyword
  };

  union Value
  {
    UnionMember<int32_t > mLong;
    UnionMember<AutoKeyword > mAutoKeyword;

  };

  Type mType;
  Value mValue;

  LongOrAutoKeyword(const LongOrAutoKeyword&) = delete;
  void operator=(const LongOrAutoKeyword) = delete;
public:
  explicit inline LongOrAutoKeyword()
    : mType(eUninitialized)
  {
  }

  inline ~LongOrAutoKeyword()
  {
    Uninit();
  }

  inline int32_t&
  RawSetAsLong()
  {
    if (mType == eLong) {
      return mValue.mLong.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eLong;
    return mValue.mLong.SetValue();
  }

  inline int32_t&
  SetAsLong()
  {
    if (mType == eLong) {
      return mValue.mLong.Value();
    }
    Uninit();
    mType = eLong;
    return mValue.mLong.SetValue();
  }

  inline bool
  IsLong() const
  {
    return mType == eLong;
  }

  inline int32_t&
  GetAsLong()
  {
    MOZ_ASSERT(IsLong(), "Wrong type!");
    return mValue.mLong.Value();
  }

  inline int32_t
  GetAsLong() const
  {
    MOZ_ASSERT(IsLong(), "Wrong type!");
    return mValue.mLong.Value();
  }

  inline AutoKeyword&
  RawSetAsAutoKeyword()
  {
    if (mType == eAutoKeyword) {
      return mValue.mAutoKeyword.Value();
    }
    MOZ_ASSERT(mType == eUninitialized);
    mType = eAutoKeyword;
    return mValue.mAutoKeyword.SetValue();
  }

  inline AutoKeyword&
  SetAsAutoKeyword()
  {
    if (mType == eAutoKeyword) {
      return mValue.mAutoKeyword.Value();
    }
    Uninit();
    mType = eAutoKeyword;
    return mValue.mAutoKeyword.SetValue();
  }

  inline bool
  IsAutoKeyword() const
  {
    return mType == eAutoKeyword;
  }

  inline AutoKeyword&
  GetAsAutoKeyword()
  {
    MOZ_ASSERT(IsAutoKeyword(), "Wrong type!");
    return mValue.mAutoKeyword.Value();
  }

  inline AutoKeyword
  GetAsAutoKeyword() const
  {
    MOZ_ASSERT(IsAutoKeyword(), "Wrong type!");
    return mValue.mAutoKeyword.Value();
  }

  inline void
  Uninit()
  {
    switch (mType) {
      case eUninitialized: {
        break;
      }
      case eLong: {
        DestroyLong();
        break;
      }
      case eAutoKeyword: {
        DestroyAutoKeyword();
        break;
      }
    }
  }

  bool
  ToJSVal(JSContext* cx, JS::Handle<JSObject*> scopeObj, JS::MutableHandle<JS::Value> rval) const;

private:
  inline void
  DestroyLong()
  {
    MOZ_ASSERT(IsLong(), "Wrong type!");
    mValue.mLong.Destroy();
    mType = eUninitialized;
  }

  inline void
  DestroyAutoKeyword()
  {
    MOZ_ASSERT(IsAutoKeyword(), "Wrong type!");
    mValue.mAutoKeyword.Destroy();
    mType = eUninitialized;
  }
};


class OwningLongOrAutoKeyword : public AllOwningUnionBase
{
  friend void ImplCycleCollectionUnlink(OwningLongOrAutoKeyword& aUnion);
  enum Type
  {
    eUninitialized,
    eLong,
    eAutoKeyword
  };

  union Value
  {
    UnionMember<int32_t > mLong;
    UnionMember<AutoKeyword > mAutoKeyword;

  };

  Type mType;
  Value mValue;

public:
  explicit inline OwningLongOrAutoKeyword()
    : mType(eUninitialized)
  {
  }

  explicit inline OwningLongOrAutoKeyword(const OwningLongOrAutoKeyword& aOther)
    : mType(eUninitialized)
  {
    *this = aOther;
  }

  inline ~OwningLongOrAutoKeyword()
  {
    Uninit();
  }

  int32_t&
  RawSetAsLong();

  int32_t&
  SetAsLong();

  bool
  TrySetToLong(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsLong() const
  {
    return mType == eLong;
  }

  inline int32_t&
  GetAsLong()
  {
    MOZ_ASSERT(IsLong(), "Wrong type!");
    return mValue.mLong.Value();
  }

  inline int32_t const &
  GetAsLong() const
  {
    MOZ_ASSERT(IsLong(), "Wrong type!");
    return mValue.mLong.Value();
  }

  AutoKeyword&
  RawSetAsAutoKeyword();

  AutoKeyword&
  SetAsAutoKeyword();

  bool
  TrySetToAutoKeyword(JSContext* cx, JS::Handle<JS::Value> value, bool& tryNext, bool passedToJSImpl = false);

  inline bool
  IsAutoKeyword() const
  {
    return mType == eAutoKeyword;
  }

  inline AutoKeyword&
  GetAsAutoKeyword()
  {
    MOZ_ASSERT(IsAutoKeyword(), "Wrong type!");
    return mValue.mAutoKeyword.Value();
  }

  inline AutoKeyword const &
  GetAsAutoKeyword() const
  {
    MOZ_ASSERT(IsAutoKeyword(), "Wrong type!");
    return mValue.mAutoKeyword.Value();
  }

  void
  Uninit();

  bool
  ToJSVal(JSContext* cx, JS::Handle<JSObject*> scopeObj, JS::MutableHandle<JS::Value> rval) const;

  void
  TraceUnion(JSTracer* trc);

  void
  operator=(const OwningLongOrAutoKeyword& aOther);

private:
  void
  DestroyLong();

  void
  DestroyAutoKeyword();
};


namespace VTTCueBinding {

  typedef mozilla::dom::TextTrackCue NativeType;

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

  bool
  ConstructorEnabled(JSContext* aCx, JS::Handle<JSObject*> aObj);

  const JSClass*
  GetJSClass();

  bool
  Wrap(JSContext* aCx, mozilla::dom::TextTrackCue* aObject, nsWrapperCache* aCache, JS::Handle<JSObject*> aGivenProto, JS::MutableHandle<JSObject*> aReflector);

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

} // namespace VTTCueBinding



} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_VTTCueBinding_h