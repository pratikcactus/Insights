/* THIS FILE IS AUTOGENERATED FROM PropertyIndexedKeyframes.webidl BY Codegen.py - DO NOT EDIT */

#ifndef mozilla_dom_PropertyIndexedKeyframesBinding_h
#define mozilla_dom_PropertyIndexedKeyframesBinding_h

#include "KeyframeBinding.h"
#include "js/RootingAPI.h"
#include "jspubtd.h"
#include "mozilla/ErrorResult.h"
#include "mozilla/dom/BindingDeclarations.h"
#include "mozilla/dom/Nullable.h"

namespace mozilla {
namespace dom {

struct NativePropertyHooks;
struct PropertyIndexedKeyframesAtoms;
class ProtoAndIfaceCache;

} // namespace dom
} // namespace mozilla

namespace mozilla {
namespace dom {

struct PropertyIndexedKeyframes : public DictionaryBase
{
  Nullable<CompositeOperation> mComposite;
  nsString mEasing;

  PropertyIndexedKeyframes();

  explicit inline PropertyIndexedKeyframes(const FastDictionaryInitializer& )
  {
    // Do nothing here; this is used by our "Fast" subclass
  }

  explicit inline PropertyIndexedKeyframes(const PropertyIndexedKeyframes& aOther)
  {
    *this = aOther;
  }

  bool
  Init(JSContext* cx, JS::Handle<JS::Value> val, const char* sourceDescription = "Value", bool passedToJSImpl = false);

  bool
  Init(const nsAString& aJSON);

  bool
  ToObjectInternal(JSContext* cx, JS::MutableHandle<JS::Value> rval) const;

  bool
  ToJSON(nsAString& aJSON) const;

  void
  TraceDictionary(JSTracer* trc);

  void
  operator=(const PropertyIndexedKeyframes& aOther);

private:
  static bool
  InitIds(JSContext* cx, PropertyIndexedKeyframesAtoms* atomsCache);
};

namespace binding_detail {
struct FastPropertyIndexedKeyframes : public PropertyIndexedKeyframes
{
  inline FastPropertyIndexedKeyframes()
    : PropertyIndexedKeyframes(FastDictionaryInitializer())
  {
    // Doesn't matter what int we pass to the parent constructor
  }
};
} // namespace binding_detail


} // namespace dom
} // namespace mozilla

#endif // mozilla_dom_PropertyIndexedKeyframesBinding_h